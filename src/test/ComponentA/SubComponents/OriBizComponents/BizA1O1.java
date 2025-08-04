package test.ComponentA.SubComponents.OriBizComponents;

import base.components.CBizCompBase;
import base.components.COriModelMgn;
import base.enums.Result;
import base.model.BizInfo;
import base.model.KeyValue;
import test.ComponentA.data.ObsAX;

public class BizA1O1 extends CBizCompBase {

    public BizA1O1(){
        this.setBizInfo(new BizInfo("ComponentA1","BizA1O1","O","desc",0x08));
    }
    @Override
    public KeyValue command(KeyValue cmd) {
        KeyValue key = new KeyValue();
         COriModelMgn parent = (COriModelMgn)this.getParent();
            key.key = 1;
            Result res = parent.getselfComponent().getInfoMgn().readKeyValue(key);
            if (res == Result.SUCCESS) {
                System.out.println("m:"+((ObsAX)key.value).m);
                System.out.println("n:"+((ObsAX)key.value).n);
            }
        return key;
    }
}
