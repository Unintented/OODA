package base.components;


import base.enums.Result;
import base.model.KeyValue;
import base.simulation.PlatformEntity;
import base.simulation.SimMessageHeader;

/**
 * 业务流程管理类
 * 对应设计文档中的CBizProcMgn
 * 继承自仿真系统的实体组件基类，具备接受仿真引擎调度，按轮次执行仿真业务逻辑的功能
 */
public class CBizProcMgn extends PlatformEntity {

    private CC2Component selfComponent;//模型对应的顶层管理对象

    /**
     * 构造函数。
     */
    public CBizProcMgn(CC2Component selfComponent) {
        this.selfComponent = selfComponent;
    }

    public Result init() {
        return Result.SUCCESS;
    }

    @Override
    public Result start() {
        return Result.SUCCESS;
    }
    @Override
    public Result stop() {
        return Result.SUCCESS;
    }
    @Override
    public Result destroy() {
        return Result.SUCCESS;
    }
    @Override
    public Result step(long dt) {
        return Result.SUCCESS;
    }
    @Override
    public Result onMessage(SimMessageHeader simMessageHeader) {
        return Result.SUCCESS;
    }
    public KeyValue command(KeyValue cmd) {
        return cmd;
    }

    /**
     * get和set方法
     */
    public CC2Component getselfComponent() {
        return selfComponent;
    }


} 