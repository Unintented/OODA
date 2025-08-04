package test.ComponentA.SubComponents.SubComponents.DecBizComponents;

import base.components.CBizCompBase;
import base.components.CDecModelMgn;
import base.enums.Result;
import base.model.BizInfo;
import base.model.KeyValue;
import test.ComponentA.data.DecAX;
import test.ComponentA.data.OriAX;

public class test1 extends CBizCompBase {
    public test1(){
        this.setBizInfo(new BizInfo("ComponentA11","test1","D","desc",0x0A));
    }
    public KeyValue command(KeyValue cmd) {
        KeyValue key = new KeyValue();
        System.out.println("leve3 command测试");
        return key;
    }
}
