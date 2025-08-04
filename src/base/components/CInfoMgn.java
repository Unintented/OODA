package base.components;


import base.enums.Result;
import base.model.KeyName;
import base.model.KeyValue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 信息管理类
 * 对应设计文档中的CInfoMgn，对应OODA模型中的第一个"O"，即Observation
 * 用来对业务逻辑中的各类信息进行整合管理，包括对信息的分类、存储管理、筛选等活动
 * 为其它组件提供信息支撑
 */
public class CInfoMgn {
    private CC2Component parentComponent;//对应的顶层管理对象
    private Map<Long, Object> dataSpace = new HashMap<>();//每个管理对象维护的自身的数据空间
    private static Map<Long, String> nameSpace = new HashMap<>();//全局统一的数据空间

    /**
     * 构造函数，初始化信息管理器。
     */
    public CInfoMgn(CC2Component parentComponent) {
        this.parentComponent = parentComponent;
    }


    public Result init() {
        return Result.SUCCESS;
    }

    /**
     * 写入数据空间。
     * @param info 键值对信息
     * @return 操作结果
     */
    public Result writeDataSpace(KeyValue info) {
        this.dataSpace.put(info.key, info.value);
        return Result.SUCCESS;
    }

    /**
     * 读取数据空间中的键值对。
     * @param info 键值对信息
     * @return 操作结果
     */
    public Result readKeyValue(KeyValue info) {
        info.value = this.dataSpace.get(info.key);

        if (info.value == null) {
            if (this.parentComponent.getStructureMgn().getParentComponent() != null) {
                Result result = this.parentComponent.getStructureMgn().getParentComponent().getInfoMgn().readKeyValue(info);
                if (result == Result.SUCCESS) {
                    return Result.SUCCESS;
                }
            }
            return Result.FAIL;
        }
        return Result.SUCCESS;
    }

    /**
     * 写入命名空间（静态方法）。
     * @param info 键名信息
     * @return 操作结果
     */
    public static synchronized Result writeNameSpace(KeyName info) {
        nameSpace.put(info.key, info.name);
        return Result.SUCCESS;
    }

    /**
     * 读取命名空间（静态方法）。
     * @param info 键名信息
     * @return 操作结果
     */
    public static synchronized Result readNameSpace(KeyName info) {
        info.name = nameSpace.get(info.key);
        if (info.name == null) {
            return Result.FAIL;
        }
        return Result.SUCCESS;
    }

    /**
     * 通过名称查询命名空间中的键（静态方法）。
     * @param key 键引用
     * @param name 名称
     * @return 操作结果
     */
    public static synchronized Result inquireNameSpace(AtomicReference<Long> key, String name) {
        for (Map.Entry<Long, String> entry : nameSpace.entrySet()) {
            if (entry.getValue().equals(name)) {
                key.set(entry.getKey());
                return Result.SUCCESS; // 找到值对应的键
            }
        }
        return Result.FAIL; // 未找到值对应的键
    }

    /**
     * 获取父组件。
     * @return 父组件
     */
    public CC2Component getParentComponent() {
        return parentComponent;
    }


}