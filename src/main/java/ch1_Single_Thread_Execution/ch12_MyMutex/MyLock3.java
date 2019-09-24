package ch1_Single_Thread_Execution.ch12_MyMutex;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: raintor
 * @Date: 2019/9/24 18:59
 * @Description:
 * 使用Atomic的CAS实现
 */
public class MyLock3 {
    private boolean isLock;
    private Thread cur;

    private final AtomicInteger ato = new AtomicInteger(0);
    public void lock(){
        isLock = ato.compareAndSet(0,1);
        if(!isLock){
            return;
        }
        cur = Thread.currentThread();
    }

    public void unlock(){
        if(ato.get() == 0){
            return;
        }
        if(cur == Thread.currentThread()){
            ato.compareAndSet(1,0);
        }
    }
    /**
     * 利用CAS操作的结果来判断获取是否成功，多线程下的获取锁通过CAS保证安全
     * 如果CAS成功，则说明强到锁。直接置1，然后记录当前线程
     * 失败就抛出
     * 释放锁的时候，需要判断是否是当前线程。
     */
}
