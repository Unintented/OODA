package base.simulation;

/**
 * 仿真消息头
 * 对应设计文档中的SimMessageHeader
 */
public class SimMessageHeader {


    private String topic;
    private long time;
    private long sender;
    private long receiver;
    private SimMessageBase message;

    /**
     * 构造函数。
     */
    public SimMessageHeader() {}
    public SimMessageHeader(String topic, long time, long sender, long receiver, SimMessageBase message) {
        this.topic = topic;
        this.time = time;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    /**
     * get和set方法
     */
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public long getSender() {
        return sender;
    }
    public void setSender(long sender) {
        this.sender = sender;
    }
    public long getReceiver() {
        return receiver;
    }
    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }
    public SimMessageBase getMessage() {
        return message;
    }
    public void setMessage(SimMessageBase message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "SimMessageHeader{" +
                "topic='" + topic + '\'' +
                ", time=" + time +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", message=" + message +
                '}';
    }
} 