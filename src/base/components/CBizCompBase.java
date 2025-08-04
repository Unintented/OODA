package base.components;


import base.enums.Result;
import base.model.BizInfo;
import base.model.KeyValue;

/**
 * 判情模型和决策模型的基类
 */
public abstract class CBizCompBase{

    private Object parent;//模型对应的顶层管理对象
    private BizInfo bizInfo;//判情模型和决策模型的信息

    /**
     * 构造函数。
     */
    public CBizCompBase() {}
    public CBizCompBase(BizInfo bizInfo) {
        this();
        this.bizInfo = bizInfo;
    }

    public Result init() {
        return Result.SUCCESS;
    }
    public BizInfo inquire() {
        return bizInfo;
    }
    public KeyValue command(KeyValue cmd) {
        return cmd;
    }


    /**
     * get和set方法
     */
    public Object getParent() {
        return this.parent;
    }
    public BizInfo getBizInfo() {
        return bizInfo;
    }
    public void setParent(Object parent) {
        this.parent = parent;
    }
    public void setBizInfo(BizInfo bizInfo) {
        this.bizInfo = bizInfo;
    }

} 