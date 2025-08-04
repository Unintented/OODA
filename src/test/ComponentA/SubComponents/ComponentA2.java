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

    //    重写的处理command的方法，逻辑同给出的文档
    @Override
    public KeyValue command(KeyValue cmd) {
        int resNum = this.getCmdRouter().router(cmd);
        System.out.printf("0x%x%n", cmd.key);
        KeyValue returndata = new KeyValue();
        int action = (int)(cmd.key & 0xFF);
        if(resNum == 0){
            for (int i = 0; i < this.getOriModelMgn().getModelCount(); i++) {
                CBizCompBase comp = this.getOriModelMgn().getBizComp(i);
                if (comp.getBizInfo().getId() == action) {
                    returndata = comp.command(cmd);
                }
            }
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
