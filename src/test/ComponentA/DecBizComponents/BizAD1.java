package test.ComponentA.DecBizComponents;

import base.components.CBizCompBase;
import base.model.BizInfo;

public class BizAD1 extends CBizCompBase {

    public BizAD1(){
        this.setBizInfo(new BizInfo("ComponentA","BizAD1","D","desc",0x01));
    }
}
