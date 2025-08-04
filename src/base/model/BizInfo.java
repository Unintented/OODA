package base.model;

/**
 * 业务组件信息描述类
 * 对应设计文档中的BizINFO结构
 * 用于描述业务组件封装的判情或决策业务逻辑的信息
 */
public class BizInfo {
    private String supName;
    private String selfName;
    private String bizType;
    private String bizDescription;



    private int id;

    /**
     * 构造函数。
     */
    public BizInfo() {}
    public BizInfo(String supName,String bizComponentName, String bizType, String bizDescription, int id) {
        this.supName = supName;
        this.selfName = bizComponentName;
        this.bizType = bizType;
        this.bizDescription = bizDescription;
        this.id = id;
    }


    /**
     * get和set方法
     */
    public String getSelfName() {return selfName;}
    public void setSelfName(String selfName) {this.selfName = selfName;}
    public String getBizType() {return bizType;}
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
    public void setSupName(String supName) {this.supName = supName;}
    public String getSupName() {return supName;}
    public String getBizDescription() {
        return bizDescription;
    }
    public void setBizDescription(String bizDescription) {
        this.bizDescription = bizDescription;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
} 