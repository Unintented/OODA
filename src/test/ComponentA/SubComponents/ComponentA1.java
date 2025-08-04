package test.ComponentA.SubComponents;

import base.components.*;
import base.enums.*;
import base.model.C2Info;
import base.model.KeyName;
import base.model.KeyValue;

public class ComponentA1 extends CC2Component {
    public ComponentA1() {
        this.setComponentInfo(new C2Info("ComponentA1","ComponentA", C2LEVEL.LEVEL_2, C2LOCATION.LOC_1, C2CABIN.CABIN_1, C2SUBJECT.SUBJECT_2, C2GROUP.GROUP_2, C2OPPS.OPPS_2));
        this.setCmdRouter(new CCmdRouter(this));
        this.setStructureMgn(new CStructureMgn(this,"src/test/ComponentA/SubComponents/SubComponents"));
        this.getStructureMgn().init();
        this.setOriModelMgn(new COriModelMgn(this,"src/test/ComponentA/SubComponents/OriBizComponents"));
        this.getOriModelMgn().init();
        this.setDecModelMgn(new CDecModelMgn(this,"src/test/ComponentA/SubComponents/DecBizComponents"));
        this.getDecModelMgn().init();
        this.setBizProcMgn(new ProcA1(this));
        this.setInfoMgn(new CInfoMgn(this));
        this.getInfoMgn().init();
        this.getInfoMgn().writeNameSpace(new KeyName(2,"观察数据A1"));
        this.getInfoMgn().writeNameSpace(new KeyName(5,"判断数据A1"));
        this.getInfoMgn().writeNameSpace(new KeyName(8,"决策数据A1"));
    }
}
