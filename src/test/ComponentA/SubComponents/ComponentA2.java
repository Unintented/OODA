package test.ComponentA.SubComponents;

import base.components.*;
import base.enums.*;
import base.model.C2Info;
import base.model.KeyName;
import base.model.KeyValue;

public class ComponentA2 extends CC2Component {
    public ComponentA2() {
        this.setComponentInfo(new C2Info("ComponentA2","ComponentA", C2LEVEL.LEVEL_2, C2LOCATION.LOC_1, C2CABIN.CABIN_2, C2SUBJECT.SUBJECT_3, C2GROUP.GROUP_3, C2OPPS.OPPS_3));
        this.setCmdRouter(new CCmdRouter(this));
        this.setStructureMgn(new CStructureMgn(this,"src/test/ComponentA/SubComponents/SubComponents"));
        this.getStructureMgn().init();
        this.setOriModelMgn(new COriModelMgn(this,"src/test/ComponentA/SubComponents/OriBizComponents"));
        this.getOriModelMgn().init();
        this.setDecModelMgn(new CDecModelMgn(this,"src/test/ComponentA/SubComponents/DecBizComponents"));
        this.getDecModelMgn().init();
        this.setBizProcMgn(new ProcA2(this));
        this.setInfoMgn(new CInfoMgn(this));
        this.getInfoMgn().init();
        this.getInfoMgn().writeNameSpace(new KeyName(3,"观察数据A2"));
        this.getInfoMgn().writeNameSpace(new KeyName(6,"判断数据A2"));
        this.getInfoMgn().writeNameSpace(new KeyName(9,"决策数据A2"));
    }
}
