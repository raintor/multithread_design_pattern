package ch1_Single_Thread_Execution.ch12_MyMutex;

/**
 * @author: raintor
 * @Date: 2019/9/24 18:40
 * @Description:
 * 通过同步方法的方式实现锁，更加严谨一点
 */
public class MyLock2 {
    private long count = 0;
    private Thread cur;

    private boolean islock = false;

    public synchronized void lock(){
        Thread me = Thread.currentThread();
        if(count>0&&me!=cur){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cur = me;
        count++;
    }

    public synchronized void unlock(){
        Thread me = Thread.currentThread();
        if(cur!=me||count == 0){
            return;
        }
        count--;
        if(count == 0){
           cur = null;
           notifyAll();
        }
    }
    /**
     * 基本思路：
     * 锁的是不同形成，可重入是通过控制相同线程来实现，相同线程则不会被wait，同时需要一个计数器去++，为释放锁保证
     */
}
