package base.model;

import java.util.Objects;

/**
 * 名值对数据结构
 * 对应设计文档中的KEY_VALUE结构
 * KEY采用UINT32，VALUE为字符串类型
 */
public class KeyValue {

    public long key;
    public Object value;
    public KeyValue() {}
    public KeyValue(long key, Object value) {
        this.key = key;
        this.value = value;
    }
} 