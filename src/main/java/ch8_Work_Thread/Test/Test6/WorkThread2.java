package ch8_Work_Thread.Test.Test6;

import ch8_Work_Thread.base.Channle;
import ch8_Work_Thread.base.Request;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2020/1/9 16:21
 * @Description:
 */
public class WorkThread2 extends Thread {
    private final Channle channle;
    private volatile boolean flag = true;
    private static final Random RANDOM = new Random();

    public WorkThread2(String name, Channle channle) {
        super(name);
        this.channle = channle;
    }

    @Override
    public void run() {
        while (flag) {
            try {
                Request request = channle.takeRequest();
                request.execute();
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                flag = false;
            }
        }
    }

    //停止线程的方法
    public void stopWorkThread(){
        flag = false;
        interrupt();

    }
}
