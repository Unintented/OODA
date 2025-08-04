package base.components;

import base.enums.Result;
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


public class CStructureMgn {

    private List<CC2Component> subComponents = new ArrayList<>();//下层指控组件



    private CC2Component selfComponent;//对应的管理对象
    private CC2Component parentComponent;//上一层的管理对象
    private File sourceDir;//下层组件的存放位置

    /**
     * 构造函数。
     */
    public CStructureMgn(CC2Component selfComponent,String sourceDir) {
        this.selfComponent = selfComponent;
//        如果传入空表示为没有下层的组件
        if(!sourceDir.equals("")){
            this.sourceDir = new File(sourceDir);
        }
    }

    public Result init() {
//        如果存在下层组件
        if(sourceDir!=null){
            loadSubComponents();
        }
        System.out.println(selfComponent.getComponentInfo().getSelfName()+"结构管理类初始化成功，加载了"+subComponents.size()+"个下级组件");
        return Result.SUCCESS;
    }

    public int getSubCount() {
        return subComponents.size();
    }


    public CC2Component getSubComp(int index) {
        try {
            if (index < 0 || index >= subComponents.size()) {
                return null;
            }
            CC2Component component = subComponents.get(index);
            return component;
        } catch (Exception e) {
            return null;
        }
    }

    public CC2Component getParentComponent() {
        return parentComponent;
    }
    public void setParentComponent(CC2Component parentComponent) {
        this.parentComponent = parentComponent;
    }
    public CC2Component getSelfComponent() {return selfComponent;}
    public void setSelfComponent(CC2Component selfComponent) {this.selfComponent = selfComponent;}
//    以下内容均为加载下层组件，逻辑较为复杂，可忽略，直接用就行，详细注释见CDecModelMgn加载的过程
    protected Result loadSubComponents() {
        try {
            String baseClassName = "base.components.CC2Component";
            List<Class<?>> subclasses = compileAndLoadSubclasses(this.sourceDir, baseClassName);

            for (Class<?> cls : subclasses) {
                CC2Component tempclass = (CC2Component) cls.getDeclaredConstructor().newInstance();
                if (Objects.equals(tempclass.getComponentInfo().getSupName(), selfComponent.getComponentInfo().getSelfName())) {
                    tempclass.getStructureMgn().setParentComponent(this.selfComponent);
                    this.subComponents.add(tempclass);
//                    if(this.parentComponent()!=null){
//                        this.parentComponent().getCmdRouter().addSubComp(tempclass.getComponentInfo());
//                    }
                    this.getSelfComponent().getCmdRouter().addSubComp(tempclass.getComponentInfo());

                    System.out.println(selfComponent.getComponentInfo().getSelfName()+"加载下级组件"+tempclass.getComponentInfo().getSelfName()+"成功");
                }
            }
            return Result.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.FAIL;
        }
    }
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

    private static void findJavaFiles(File dir, List<File> list) {
        for (File f : Objects.requireNonNull(dir.listFiles())) {
//            if (f.isDirectory()) {
//                findJavaFiles(f, list);
//            } else if (f.getName().endsWith(".java")) {
//                list.add(f);
//            }
            if (f.isFile() && f.getName().endsWith(".java")) {
                list.add(f); // 只添加当前目录下的 .java 文件
            }
        }
    }

    private static String getClassNameFromFile(File javaFile) {
        String fullPath = javaFile.getAbsolutePath().replace(File.separatorChar, '/');
        int index = fullPath.indexOf("/src/");
        if (index == -1) throw new RuntimeException("路径中不包含 /src/");

        String relative = fullPath.substring(index + 5); // 跳过 "/src/"
        return relative.replace('/', '.').replace(".java", "");
    }



} 