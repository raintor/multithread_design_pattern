package ch1_Single_Thread_Execution.ch12_MyMutex;

import java.util.concurrent.Semaphore;

/**
 * @author: raintor
 * @Date: 2019/9/24 19:11
 * @Description:
 * 利用Semphore实现
 */
public class MyLock4 {
    private final Semaphore sem = new Semaphore(1);
    private Thread cur;
    public void lock(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cur = Thread.currentThread();
    }

    public void unlock(){
        if(cur == Thread.currentThread()){
            sem.release();
            cur = null;
        }
    }

    /**
     * 由于semaphore内部就是通过CAS，AQS实现的，所以直接利用acquire与releas方法，就可以时间多线程的控制，
     * 没有获取到的就会自行等待
     */
}
