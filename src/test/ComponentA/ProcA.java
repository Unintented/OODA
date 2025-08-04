package test.ComponentA;

import base.components.CBizProcMgn;
import base.components.CC2Component;
import base.enums.Result;
import base.model.KeyValue;
import test.ComponentA.data.ObsAX;

import java.util.concurrent.atomic.AtomicReference;

public class ProcA extends CBizProcMgn {
    private int count = 0;
    private int time = 0;

    /**
     * 构造函数，初始化ProcA对象。
     * @param parentComponent 父组件
     */
    public ProcA(CC2Component parentComponent) {
        super(parentComponent);
    }

    /**
     * 步进函数，每调用一次计数加一，计数到10时执行一次数据写入和读取操作。
     * @param dt 步进时间间隔
     * @return 操作结果
     */
    @Override
    public Result step(long dt) {
        this.count++;
        if (this.count == 10) {
            System.out.println("Hello A");
            this.time++;
            ObsAX tempdata = new ObsAX();
            tempdata.m = this.time;
            tempdata.n = this.time;
            KeyValue info = new KeyValue(1, new ObsAX());
            this.getselfComponent().getInfoMgn().writeDataSpace(new KeyValue(1, tempdata));
            this.getselfComponent().getInfoMgn().readKeyValue(info);

//            System.out.println(((ObsAX)info.value).m+((ObsAX)info.value).n);
//            AtomicReference<Long> keyRef = new AtomicReference<>();
//            Result res = getParentComponent().getInfoMgn().inquireNameSpace(keyRef, "观察数据A");
//            if (res == Result.SUCCESS) {
//                Long key = keyRef.get();
//                System.out.println(key);
//            }
            this.count = 0;
        }
        return Result.SUCCESS;
    }
}
