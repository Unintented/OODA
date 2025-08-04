package base.components;

import base.enums.Result;
import base.model.KeyValue;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 决策模型管理类
 * 对应设计文档中的CDecModelMgn，对应OODA模型中的"D"，即Decision
 * 用来对业务逻辑中的各类战术决策模型进行统一封装和调用
 */
public class CDecModelMgn {
    private CC2Component selfComponent;//对应的管理对象
    private final List<CBizCompBase> bizComponents;
    private File sourceDir;//下层组件的存放位置


    /**
     * 构造函数，初始化决策模型管理器。
     * @param selfComponent 父组件
     * @param sourceDir 源码目录
     */
    public CDecModelMgn(CC2Component selfComponent,String sourceDir) {
        this.bizComponents = new ArrayList<>();
        this.selfComponent = selfComponent;
        if(!sourceDir.equals("")){
            this.sourceDir = new File(sourceDir);
        }
    }
    
    /**
     * 初始化方法，加载业务组件。
     * @return 操作结果
     */
    public Result init() {
        bizComponents.clear();
        try {
            // 执行具体的组件加载逻辑
            Result result = Result.SUCCESS;
            if(sourceDir!=null){
                result = loadBizComponents();
            }
            System.out.println(selfComponent.getComponentInfo().getSelfName()+"决策模型管理类初始化成功,加载了"+bizComponents.size()+"个下级组件");

            return result;
        } catch (Exception e) {
            return Result.FAIL;
        }
    }
    /**
     * 加载业务组件。
     * @return 操作结果
     */
    private Result loadBizComponents() {
        try {
            String baseClassName = "base.components.CBizCompBase";
            List<Class<?>> subclasses = compileAndLoadSubclasses(this.sourceDir, baseClassName);

            for (Class<?> cls : subclasses) {
                CBizCompBase tempclass = (CBizCompBase) cls.getDeclaredConstructor().newInstance();
                if (Objects.equals(tempclass.getBizInfo().getSupName(), selfComponent.getComponentInfo().getSelfName())) {
                    tempclass.setParent(this);
                    this.bizComponents.add(tempclass);
                    System.out.println(selfComponent.getComponentInfo().getSelfName()+"加载下级组件"+tempclass.getBizInfo().getSelfName()+"成功");
                }
            }
            return Result.SUCCESS;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.FAIL;
        }
    }
    /**
     * 编译并加载所有继承自指定基类的子类。
     * @param dir 源码目录
     * @param baseClassName 基类名
     * @return 子类列表
     * @throws Exception 异常
     */
    private static List<Class<?>> compileAndLoadSubclasses(File dir, String baseClassName) throws Exception {
        List<Class<?>> result = new ArrayList<>();

        // 1. 找到所有 .java 文件
        List<File> javaFiles = new ArrayList<>();
        findJavaFiles(dir, javaFiles);

        if (javaFiles.isEmpty()) return result;

        // 2. 编译这些文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(javaFiles);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);

        boolean success = task.call();
        fileManager.close();

        if (!success) throw new RuntimeException("编译失败");

        // 3. 构建类加载器（从 src 目录作为根）
        File root = new File("src");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{root.toURI().toURL()});

        // 4. 加载基类
        Class<?> baseClass = Class.forName(baseClassName);  // 使用当前类加载器

        // 5. 加载所有编译后的类
        for (File file : javaFiles) {
            String className = getClassNameFromFile(file);
            try {
                Class<?> cls = classLoader.loadClass(className);
                if (baseClass.isAssignableFrom(cls) && !cls.equals(baseClass)) {
                    result.add(cls);
                }
            } catch (Exception e) {
                System.out.println("跳过类：" + className + " → " + e.getMessage());
            }
        }

        return result;
    }
    /**
     * 递归查找目录下所有Java文件。
     * @param dir 目录
     * @param list 文件列表
     */
    private static void findJavaFiles(File dir, List<File> list) {
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.isDirectory()) {
                findJavaFiles(f, list);
            } else if (f.getName().endsWith(".java")) {
                list.add(f);
            }
        }
    }
    /**
     * 从Java文件获取类名。
     * @param javaFile Java文件
     * @return 类名
     */
    private static String getClassNameFromFile(File javaFile) {
        String fullPath = javaFile.getAbsolutePath().replace(File.separatorChar, '/');
        int index = fullPath.indexOf("/src/");
        if (index == -1) throw new RuntimeException("路径中不包含 /src/");

        String relative = fullPath.substring(index + 5); // 跳过 "/src/"
        return relative.replace('/', '.').replace(".java", "");
    }

    public int getModelCount() {
        return bizComponents.size();
    }

    public CBizCompBase getBizComp(int index) {
        try {
            if (index >= 0 && index < bizComponents.size()) {
                return bizComponents.get(index);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public KeyValue command(KeyValue cmd) {
        return cmd;
    }

    public CC2Component getselfComponent() {
        return selfComponent;
    }

} 