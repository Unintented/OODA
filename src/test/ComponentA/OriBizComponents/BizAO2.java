package test.ComponentA.OriBizComponents;

import base.components.CBizCompBase;
import base.model.BizInfo;

public class BizAO2 extends CBizCompBase {

    public BizAO2(){
        this.setBizInfo(new BizInfo("ComponentA","BizAO2","O","desc",0x05));
    }
}
