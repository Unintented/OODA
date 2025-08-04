package test.ComponentA.SubComponents.DecBizComponents;

import base.components.CBizCompBase;
import base.components.CDecModelMgn;
import base.enums.Result;
import base.model.BizInfo;
import base.model.KeyValue;
import test.ComponentA.data.DecAX;
import test.ComponentA.data.OriAX;

public class BizA2D1 extends CBizCompBase {

    public BizA2D1(){
        this.setBizInfo(new BizInfo("ComponentA2","BizA2D1","D","desc",0x07));

    }
    @Override
    public KeyValue command(KeyValue cmd) {
        KeyValue key = new KeyValue();
        CDecModelMgn parent = (CDecModelMgn)this.getParent();
        KeyValue key2 = new KeyValue();
        key2.key = 7;
        Result r = parent.getselfComponent().getInfoMgn().readKeyValue(key2);
        if (r == Result.SUCCESS) {
            System.out.println("read key=7,DecAX m:"+((DecAX)key2.value).m);
            System.out.println("read key=7,DecAX-OriAX m:"+((OriAX)((DecAX)key2.value).orid).m);
        }
        return key;
    }
}
