package test.ComponentA.SubComponents;

import base.components.CBizProcMgn;
import base.components.CC2Component;
import base.enums.Result;
import base.model.KeyValue;
import test.ComponentA.data.ObsAX;
import test.ComponentA.data.OriAX;

public class ProcA1 extends CBizProcMgn {
    private int count = 0;
    private int time = 0;
    public ProcA1(CC2Component parentComponent) {
        super(parentComponent);
    }
    @Override
    public Result step(long dt) {
        this.count++;
        if (this.count == 20) {
            time++;
            System.out.println("Hello A1");
            KeyValue data0 = this.getselfComponent().command(new KeyValue(0x3111550A,100));

//           原文档中命令100|100
            KeyValue data = this.getselfComponent().command(new KeyValue(0x21122208,100));
            ObsAX dataObsAX = (ObsAX)(data.value);
            OriAX a1Data = new OriAX();
            a1Data.m = time;
            a1Data.obsd = new ObsAX();
            a1Data.obsd.m = dataObsAX.m;
            a1Data.obsd.n = dataObsAX.n;
            this.getselfComponent().getInfoMgn().writeDataSpace(new KeyValue(5,a1Data));
            this.count = 0;
            if (time%5 == 0){
//           原文档中命令200|100
                KeyValue data2 = this.getselfComponent().command(new KeyValue(0x21122206,100));
            }
        }
        return Result.SUCCESS;
    }
}
