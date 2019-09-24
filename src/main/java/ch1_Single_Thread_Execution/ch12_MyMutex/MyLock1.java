package ch1_Single_Thread_Execution.ch12_MyMutex;

/**
 * @author: raintor
 * @Date: 2019/9/24 17:05
 * @Description:
 * 采用synchronize加上wait与notify简单实现，存在几个问题
 */
public class MyLock1 {
    private boolean isLock  = false;

    public synchronized void lock(){
        while (isLock){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
    }

    public synchronized void unlock(){
        isLock = false;
        notifyAll();
    }

    /**
     *
     * 采用这种简单的方式，基本思想：
     * （1）lock方法采用同步方法，设置标志位，如果有一个抢到了锁，就设置标志位为true，后面的线程进入
     * 判断标志位后，就说进入wait方法
     *
     * （2）释放锁就是notifyAll，然后重置标志位
     *
     * 但是这么做有如下缺点：
     * （1）不可重入
     * （2）任何线程都可以释放锁。
     *
     */
}

