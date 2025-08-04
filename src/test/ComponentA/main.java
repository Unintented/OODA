package test.ComponentA;

public class main {
    /**
     * 主函数，程序入口，初始化组件并启动循环。
     * @param args 命令行参数
     * @throws InterruptedException 线程中断异常
     */
    public static void main(String[] args) throws InterruptedException {
//        创建顶层的指控组件
        ComponentA a = new ComponentA();
//        创建循环
        Loop loop = new Loop();
//        依次添加组件进入循环
        loop.addProc(a.getBizProcMgn());
        loop.addProc(a.getStructureMgn().getSubComp(0).getBizProcMgn());
        loop.addProc(a.getStructureMgn().getSubComp(1).getBizProcMgn());
//        循环开始
        loop.start();

    }
}
