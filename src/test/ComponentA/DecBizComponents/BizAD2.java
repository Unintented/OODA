package test.ComponentA.DecBizComponents;

import base.components.CBizCompBase;
import base.model.BizInfo;

public class BizAD2 extends CBizCompBase {

    public BizAD2(){
        this.setBizInfo(new BizInfo("ComponentA","BizAD2","D","desc",0x02));
    }
}
