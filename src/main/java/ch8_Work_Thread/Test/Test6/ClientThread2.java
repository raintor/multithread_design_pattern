package ch8_Work_Thread.Test.Test6;

import ch8_Work_Thread.base.Channle;
import ch8_Work_Thread.base.Request;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2020/1/9 16:16
 * @Description:
 * 设置CLientThread可以停止
 * 使用标志位
 */
public class ClientThread2 extends Thread{
    private final Channle channle;
    private static final Random RANDOM = new Random();
    private volatile boolean flag = true;
    public ClientThread2(String name, Channle channle) {
        super(name);
        this.channle = channle;
    }

    @Override
    public void run() {
        for(int i = 0;flag;i++){
            try {
                Request request = new Request(getName(),i);
                channle.putRequest(request);
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                flag = false;
            }
        }
    }

    //停止方法
    public void stopClientThread(){
        flag = false;
        interrupt();
    }
}
