package ch8_Work_Thread.Test;

import ch8_Work_Thread.base.Channle;
import ch8_Work_Thread.base.Request;

import java.util.concurrent.ThreadFactory;

/**
 * @author: raintor
 * @Date: 2020/1/9 15:56
 * @Description:
 * 修改Channel，使得每次创建新的线程去处理请求------Thread-per-Message
 */
public class Test2 extends Channle {
    public Test2(int threads) {
        super(threads);
    }

    @Override
    public synchronized void putRequest(Request request) {
       new Thread(){
           @Override
           public void run() {
               request.execute();
           }
       }.start();
    }
}
