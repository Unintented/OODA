package base.components;

import base.enums.Result;
import base.model.C2Info;
import base.model.KeyValue;
import java.util.ArrayList;
import java.util.List;

public class CCmdRouter {

    private CC2Component selfComponent;//对应的顶层管理对象
    private List<C2Info> subC2Info = new ArrayList<>();//下一层的所有组件的C2Info

    /**
     * 构造函数。
     */
    public CCmdRouter(CC2Component selfComponent) {
        this.selfComponent = selfComponent;
    }

    public Result init() {
        return Result.SUCCESS;
    }

    public Result addSubComp(C2Info info) {
        this.subC2Info.add(info);
        return Result.SUCCESS;
    }

    //    路由表
    public int router(KeyValue cmd) {
        System.out.printf(this.getselfComponent().getComponentInfo().getSelfName()+" get command 0x%x%n", cmd.key);

        long key = cmd.key;
        long level = (key >>> 28) & 0xFL;         // 31~28 位：4 位
        long location = (key >>> 24) & 0xFL;         // 31~28 位：4 位
        long cabin = (key >>> 20) & 0xFL;         // 31~28 位：4 位
        long subject = (key >>> 16) & 0xFL;         // 31~28 位：4 位
        long group = (key >>> 12) & 0xFL;         // 31~28 位：4 位
        long opps = (key >>> 8) & 0xFL;           // 11~8 位：4 位
        if (level == this.selfComponent.getComponentInfo().getLevel().getValue()) {
            return 0;
        } else if (this.getselfComponent().getComponentInfo().getLevel().getValue() == 1) {
            for (int i = 0; i < subC2Info.size(); i++) {
                C2Info info = subC2Info.get(i);
                if (cabin == info.getCabin().getValue()) {
                    return i + 1;//0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
                }
            }
        } else if (this.getselfComponent().getComponentInfo().getLevel().getValue() == 2) {
            for (int i = 0; i < subC2Info.size(); i++) {
                C2Info info = subC2Info.get(i);
                if (subject == info.getSubject().getValue()) {
                    return i + 1;//0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
                }
            }
        } else if (this.getselfComponent().getComponentInfo().getLevel().getValue() == 3) {
            for (int i = 0; i < subC2Info.size(); i++) {
                C2Info info = subC2Info.get(i);
                if (group == info.getGroup().getValue()) {
                    return i + 1;//0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
                }
            }
        } else if (this.getselfComponent().getComponentInfo().getLevel().getValue() == 4) {
            for (int i = 0; i < subC2Info.size(); i++) {
                C2Info info = subC2Info.get(i);
                if (opps == info.getOpps().getValue()) {
                    return i + 1;//0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
                }
            }
        }
        return -1;
    }

    /**
     * get和set方法
     */
    public CC2Component getselfComponent() {
        return selfComponent;
    }

    public void setselfComponent(CC2Component selfComponent) {
        this.selfComponent = selfComponent;
    }


}
