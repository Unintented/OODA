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
        long key = cmd.key;
        long level = (key >>> 28) & 0xFL;         // 31~28 位：4 位
        long location = (key >>> 24) & 0xFL;         // 31~28 位：4 位
        long cabin = (key >>> 20) & 0xFL;         // 31~28 位：4 位
        long subject = (key >>> 16) & 0xFL;         // 31~28 位：4 位
        long group = (key >>> 12) & 0xFL;         // 31~28 位：4 位
        long opps = (key >>> 8) & 0xFL;           // 11~8 位：4 位
        if (level == this.selfComponent.getComponentInfo().getLevel().getValue()) {
            return 0;
        } else if ((level + 1) == this.selfComponent.getComponentInfo().getLevel().getValue()) {
            for (int i = 0; i < subC2Info.size(); i++) {
                C2Info info = subC2Info.get(i);
                if (location == info.getLocation().getValue()
                        && cabin == info.getCabin().getValue()
                        && subject == info.getSubject().getValue()
                        && group == info.getGroup().getValue()
                        && opps == info.getOpps().getValue()) {
                    return i + 1;//0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
                }
            }
        } else {
            for (int i = 0; i < subC2Info.size(); i++) {
                C2Info info = subC2Info.get(i);
                if (info.getLevel().getValue() == 3) {
                    if (location == info.getLocation().getValue()
                            && cabin == info.getCabin().getValue()) {
                        return i + 1;//0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
                    }
                } else if (info.getLevel().getValue() == 4) {
                    if (location == info.getLocation().getValue()
                            && cabin == info.getCabin().getValue()
                            && subject == info.getSubject().getValue()) {
                        return i + 1;//0表示本身，所以在返回时只能加1表示是序号是0的子组件，实际调用的时候需要减去1
                    }
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
