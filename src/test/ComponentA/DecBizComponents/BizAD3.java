package test.ComponentA.DecBizComponents;

import base.components.CBizCompBase;
import base.model.BizInfo;

public class BizAD3 extends CBizCompBase {

    public BizAD3(){
        this.setBizInfo(new BizInfo("ComponentA","BizAD3","D","desc",0x03));
    }
}
