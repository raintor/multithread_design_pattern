package ch5_produer_consumer.mysleep;

/**
 * @author: raintor
 * @Date: 2019/10/13 20:51
 * @Description:
 * 通过wait方法实现sleep功能
 *
 */
public class MySleep {
    public static void sleep(long x) throws InterruptedException {
        if(x!=0){
            Object object = new Object();
            synchronized (object){
                object.wait(x);
            }
        }
    }

    /**
     * 这里使用wait方法模拟sleep方法：
     * （1）注意wait（0）与sleep（0）的区别，所以这里把x=0过滤掉
     * （2）注意wait被外部notify或者notifyAll，所以内部加锁。
     */
}
