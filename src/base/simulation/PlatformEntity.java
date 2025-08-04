package base.simulation;


import base.enums.Result;
import base.model.KeyValue;

/**
 * 仿真平台实体基类
 * 对应设计文档中的PlatformEntity
 * 提供仿真引擎的基础功能，包括启动、停止、消息处理等
 */
public abstract class PlatformEntity {
    public Result start() {
        return Result.SUCCESS;
    }
    public Result stop() {
        return Result.SUCCESS;
    }
    public Result destroy() {
        return Result.SUCCESS;
    }

    public abstract Result step(long dt);
    public abstract Result onMessage(SimMessageHeader simMessageHeader);
    public abstract KeyValue command(KeyValue command);
} 