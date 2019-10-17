package ch7_Thread_Per_Message.enhance_performance;

/**
 * @author: raintor
 * @Date: 2019/10/17 20:25
 * @Description:
 */
public class MyFrame {
    //原始
    public void windowsFrom(){
        Service.service();
    }

    //改进1：采用per——Thread 模式，这样，每次调用都会有结果
    public void windowsFrom1(){
        new Thread(){
            @Override
            public void run() {
                Service.service();
            }
        }.start();
    }
    /**
     * 这样对于每次调用，都会有结果产生，而且是调用之间并发执行。
     */

    //改进2：添加Single-Thread模式
    //并发执行输出混在一起，这样可以添加single模式来相互独立
    //在service方法上添加synchronize

    /**
     * 上述操作对于
     */
}
