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
    }
    @Override
    public KeyValue command(KeyValue cmd) {
        int resNum = this.getCmdRouter().router(cmd);
        KeyValue returndata = new KeyValue();
        int action = (int)(cmd.key & 0xFF);
        if(resNum == 0){
            for (int i = 0; i < this.getDecModelMgn().getModelCount(); i++) {
                CBizCompBase comp = this.getDecModelMgn().getBizComp(i);
                if (comp.getBizInfo().getId() == action) {
                    returndata = comp.command(cmd);
                }
            }
            return returndata;
        }else if (resNum == -1){
            return null;
        }else {
            returndata = this.getStructureMgn().getSubComp(resNum-1).command(cmd);//resnum=0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
            return returndata;
        }
    }
}
