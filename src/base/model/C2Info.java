package base.model;

import base.enums.*;

/**
 * C2组件信息描述类
 * 对应设计文档中的C2INFO结构
 * 用于描述组件的所属部位、负责业务类型等信息
 */
public class C2Info {

    private String selfName;
    private String supName;
    private C2LEVEL level;//指挥业务层级
    private C2LOCATION location;//指控业务所属部位
    private C2CABIN cabin;//指控业务所属舱室
    private C2SUBJECT subject;//指控业务所属科目
    private C2GROUP group;//指控业务所属分组
    private C2OPPS opps;//指控业务所属战位

    /**
     * 构造函数。
     */
    public C2Info() {}
    public C2Info(String selfName, String supName, C2LEVEL level, C2LOCATION location, C2CABIN cabin, C2SUBJECT subject, C2GROUP group, C2OPPS opps) {
        this.selfName = selfName;
        this.supName = supName;
        this.level = level;
        this.location = location;
        this.cabin = cabin;
        this.subject = subject;
        this.group = group;
        this.opps = opps;
    }


    /**
     * get和set方法
     */
    public C2LEVEL getLevel() {return level;}
    public void setLevel(C2LEVEL level) {this.level = level;}
    public C2LOCATION getLocation() {return location;}
    public void setLocation(C2LOCATION location) {this.location = location;}
    public C2CABIN getCabin() {return cabin;}
    public void setCabin(C2CABIN cabin) {this.cabin = cabin;}
    public C2SUBJECT getSubject() {return subject;}
    public void setSubject(C2SUBJECT subject) {this.subject = subject;}
    public C2GROUP getGroup() {return group;}
    public void setGroup(C2GROUP group) {this.group = group;}
    public C2OPPS getOpps() {return opps;}
    public void setOpps(C2OPPS opps) {this.opps = opps;}
    public String getSelfName() {return selfName;}
    public void setSelfName(String selfName) {this.selfName = selfName;}
    public String getSupName() {return supName;}
    public void setSupName(String supName) {this.supName = supName;}

} 