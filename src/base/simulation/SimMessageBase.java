package base.simulation;

import java.io.Serializable;

/**
 * 仿真消息基类
 * 对应设计文档中的SimMessageBase
 */
public abstract class SimMessageBase implements Serializable {
    private String messageType;
    private String content;
    private long timestamp;

    /**
     * 构造函数。
     */
    public SimMessageBase() {
        this.timestamp = System.currentTimeMillis();
    }
    public SimMessageBase(String messageType, String content) {
        this();
        this.messageType = messageType;
        this.content = content;
    }

    /**
     * get和set方法
     */
    public String getMessageType() {
        return messageType;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "SimMessageBase{" +
                "messageType='" + messageType + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
} 