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
    public CC2Component() {}


    public Result init(C2Mode mode) {
        this.currentMode = mode;
        return Result.SUCCESS;
    }

    public C2Info inquire() {
        return componentInfo;
    }

//    处理命令的方法，需重写
    public KeyValue command(KeyValue cmd) {
        return cmd;
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