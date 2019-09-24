package ch1_Single_Thread_Execution;

/**
 * @author: raintor
 * @Date: 2019/9/24 15:03
 * @Description:
 * 主线程类，用于启动线程以及相关初始化操作
 *
 */
public class Main {
    public static void main(String[] args) {
        Gate gate = new Gate();
        new UserThread("Alia","Australia",gate).start();
        new UserThread("Baba","Braliza",gate).start();
        new UserThread("Calian","Canada",gate).start();
    }
}
