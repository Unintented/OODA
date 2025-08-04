package test.ComponentA.SubComponents;

import base.components.CC2Component;
import base.components.CStructureMgn;
import base.enums.*;
import base.model.C2Info;

public class ComponentA3 extends CC2Component {
    public ComponentA3() {
        this.setComponentInfo(new C2Info("ComponentA3","ComponentA" ,C2LEVEL.LEVEL_2, C2LOCATION.LOC_1, C2CABIN.CABIN_3, C2SUBJECT.SUBJECT_4, C2GROUP.GROUP_4, C2OPPS.OPPS_4));
        this.setStructureMgn(new CStructureMgn(this,"src/test/ComponentA/SubComponents/SubComponents"));
        this.getStructureMgn().init();

    }
}
