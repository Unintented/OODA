package test.ComponentA;

import base.components.*;
import base.enums.*;
import base.model.C2Info;
import base.model.KeyName;

public class ComponentA extends CC2Component {
    public ComponentA(){
//        添加C2Info信息
        this.setComponentInfo(new C2Info("ComponentA","", C2LEVEL.LEVEL_1, C2LOCATION.LOC_1, C2CABIN.CABIN_1, C2SUBJECT.SUBJECT_1, C2GROUP.GROUP_1, C2OPPS.OPPS_1));
//        添加路由管理类
        this.setCmdRouter(new CCmdRouter(this));
//        添加管理类，给出下层组件的位置
        this.setStructureMgn(new CStructureMgn(this,"src/test/ComponentA/SubComponents"));
        this.getStructureMgn().init();
        this.setOriModelMgn(new COriModelMgn(this,"src/test/ComponentA/OriBizComponents"));
        this.getOriModelMgn().init();
        this.setDecModelMgn(new CDecModelMgn(this,"src/test/ComponentA/DecBizComponents"));
        this.getDecModelMgn().init();
//        添加流程管理类
        this.setBizProcMgn(new ProcA(this));
//        添加信息管理类
        this.setInfoMgn(new CInfoMgn(this));
        this.getInfoMgn().init();
        this.getInfoMgn().writeNameSpace(new KeyName(1,"观察数据A"));
        this.getInfoMgn().writeNameSpace(new KeyName(4,"判断数据A"));
        this.getInfoMgn().writeNameSpace(new KeyName(7,"决策数据A"));

    }
}

