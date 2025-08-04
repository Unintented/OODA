package test.ComponentA;

import base.components.CBizProcMgn;
import base.components.CC2Component;

import java.util.ArrayList;
import java.util.List;

public class Loop {
    private List<CBizProcMgn> procs = new ArrayList<>();

    public Loop() {}

//添加流程管理类，以便循环调用
    public void addProc(CBizProcMgn procMgn) {
        procs.add(procMgn);
    }
//循环调用所有添加的流程管理类
    public void start() throws InterruptedException {
        while (true) {
            for (CBizProcMgn procMgn : procs) {
                Thread.sleep(100);
                procMgn.step(100);
            }
        }
    }
}
