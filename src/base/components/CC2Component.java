package base.components;


import base.enums.C2Mode;
import base.enums.Result;
import base.model.C2Info;
import base.model.KeyValue;

/**
 * C2组件顶层管理类
 * 对应设计文档中的CC2Component
 * 该类是C2组件的顶层管理类，负责对其它类进行集成，支持层次化结构
 */
public class CC2Component {
    //    若干xxx类与ppt和文档的名称均一致
    private CStructureMgn structureMgn;
    private CBizProcMgn bizProcMgn;
    private CInfoMgn infoMgn;
    private COriModelMgn oriModelMgn;
    private CDecModelMgn decModelMgn;
    private C2Info componentInfo;
    private C2Mode currentMode;
    private CCmdRouter cmdRouter;

    /**
     * 构造函数。
     */
    public CC2Component() {
    }


    public Result init(C2Mode mode) {
        this.currentMode = mode;
        return Result.SUCCESS;
    }

    public C2Info inquire() {
        return componentInfo;
    }

    //    处理命令的方法
    public KeyValue command(KeyValue cmd) {
        int resNum = this.getCmdRouter().router(cmd);
        System.out.println(resNum);
        KeyValue returndata = new KeyValue();
        int action = (int) (cmd.key & 0xFF);
        if (resNum == 0) {
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
        } else if (resNum == -1) {
            return null;
        } else {
            returndata = this.getStructureMgn().getSubComp(resNum - 1).command(cmd);//resnum=0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
            return returndata;
        }
    }

    /**
     * get和set方法
     */
    public CStructureMgn getStructureMgn() {
        return structureMgn;
    }

    public void setStructureMgn(CStructureMgn structureMgn) {
        this.structureMgn = structureMgn;
    }

    public CBizProcMgn getBizProcMgn() {
        return bizProcMgn;
    }

    public void setBizProcMgn(CBizProcMgn bizProcMgn) {
        this.bizProcMgn = bizProcMgn;
    }

    public CInfoMgn getInfoMgn() {
        return infoMgn;
    }

    public void setInfoMgn(CInfoMgn infoMgn) {
        this.infoMgn = infoMgn;
    }

    public COriModelMgn getOriModelMgn() {
        return oriModelMgn;
    }

    public void setOriModelMgn(COriModelMgn oriModelMgn) {
        this.oriModelMgn = oriModelMgn;
    }

    public CDecModelMgn getDecModelMgn() {
        return decModelMgn;
    }

    public void setDecModelMgn(CDecModelMgn decModelMgn) {
        this.decModelMgn = decModelMgn;
    }

    public C2Info getComponentInfo() {
        return componentInfo;
    }

    public void setComponentInfo(C2Info componentInfo) {
        this.componentInfo = componentInfo;
    }

    public C2Mode getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(C2Mode currentMode) {
        this.currentMode = currentMode;
    }

    public CCmdRouter getCmdRouter() {
        return cmdRouter;
    }

    public void setCmdRouter(CCmdRouter cmdRouter) {
        this.cmdRouter = cmdRouter;
    }

} 