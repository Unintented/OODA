package test.ComponentA.SubComponents.SubComponents;

import base.components.CC2Component;
import base.components.CStructureMgn;
import base.enums.*;
import base.model.C2Info;

public class ComponentA22 extends CC2Component {
    public  ComponentA22() {
        this.setComponentInfo(new C2Info("ComponentA22","ComponentA2", C2LEVEL.LEVEL_3, C2LOCATION.LOC_1, C2CABIN.CABIN_2, C2SUBJECT.SUBJECT_1, C2GROUP.GROUP_6, C2OPPS.OPPS_6));
        this.setStructureMgn(new CStructureMgn(this,""));
        this.getStructureMgn().init();
    }
}
