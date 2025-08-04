package test.ComponentA.SubComponents;

import base.components.CBizProcMgn;
import base.components.CC2Component;
import base.enums.Result;
import base.model.KeyValue;

public class ProcA2 extends CBizProcMgn {
    private int count = 0;
    public ProcA2(CC2Component parentComponent) {
        super(parentComponent);
    }
    @Override
    public Result step(long dt) {
        this.count++;
        if (this.count == 30) {
            System.out.println("Hello A2");
//            原文档中命令300
            KeyValue data = this.getselfComponent().command(new KeyValue(0x21233307,100));

            this.count = 0;
        }
        return Result.SUCCESS;
    }
}
