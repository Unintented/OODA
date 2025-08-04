package base.model;

/**
 * 名值对数据结构
 * 对应设计文档中的全局共享结构
 * KEY采用UINT32，VALUE为字符串类型
 */
public class KeyName {
    public long key;
    public String name;
    public KeyName(long key, String name) {
        this.key = key;
        this.name = name;
    }

}
