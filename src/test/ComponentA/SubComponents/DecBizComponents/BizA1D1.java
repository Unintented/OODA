package test.ComponentA.SubComponents.DecBizComponents;

import base.components.CBizCompBase;
import base.components.CDecModelMgn;
import base.components.COriModelMgn;
import base.enums.Result;
import base.model.BizInfo;
import base.model.KeyValue;
import test.ComponentA.data.DecAX;
import test.ComponentA.data.ObsAX;
import test.ComponentA.data.OriAX;

public class BizA1D1 extends CBizCompBase {
    public BizA1D1(){
        this.setBizInfo(new BizInfo("ComponentA1","BizA1D1","D","desc",0x06));
    }
    @Override
    public KeyValue command(KeyValue cmd) {
        KeyValue key = new KeyValue();
        CDecModelMgn parent = (CDecModelMgn)this.getParent();
        key.key = 5;
        Result res = parent.getselfComponent().getInfoMgn().readKeyValue(key);
        if (res == Result.SUCCESS) {
            System.out.println("OriAXm:"+((OriAX)key.value).m);
            System.out.println("OriAXobsdm:"+((OriAX)key.value).obsd.m);
            System.out.println("OriAXobsdn:"+((OriAX)key.value).obsd.n);
            DecAX data =  new DecAX();
            data.m = ((OriAX)key.value).m;
            data.orid = new OriAX();
            data.orid.m = ((OriAX)key.value).m;
            data.orid.obsd = ((OriAX)key.value).obsd;
            parent.getselfComponent().getStructureMgn().getParentComponent().getInfoMgn().writeDataSpace(new KeyValue(7,data));
        }
        return key;
    }
}
