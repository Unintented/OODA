package test.ComponentA.SubComponents.SubComponents;

import base.components.*;
import base.enums.*;
import base.model.C2Info;
import base.model.KeyValue;

public class ComponentA11 extends CC2Component {
    public  ComponentA11() {
        this.setComponentInfo(new C2Info("ComponentA11","ComponentA1", C2LEVEL.LEVEL_3, C2LOCATION.LOC_1, C2CABIN.CABIN_1, C2SUBJECT.SUBJECT_1, C2GROUP.GROUP_5, C2OPPS.OPPS_5));
        this.setCmdRouter(new CCmdRouter(this));
        this.setStructureMgn(new CStructureMgn(this,""));
        this.getStructureMgn().init();
        this.setDecModelMgn(new CDecModelMgn(this,"src/test/ComponentA/SubComponents/SubComponents/DecBizComponents"));
        this.getDecModelMgn().init();
        this.setOriModelMgn(new COriModelMgn(this,"src/test/ComponentA/SubComponents/SubComponents/OriBizComponents"));
        this.getOriModelMgn().init();
    }
}
