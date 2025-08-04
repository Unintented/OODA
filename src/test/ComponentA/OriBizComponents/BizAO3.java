package test.ComponentA.OriBizComponents;

import base.components.CBizCompBase;
import base.model.BizInfo;

public class BizAO3 extends CBizCompBase {

    public BizAO3(){
        this.setBizInfo(new BizInfo("ComponentA","BizAO3","O","desc",0x05));
    }
}
