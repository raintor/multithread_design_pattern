
package ch10_Tow_Phase_Termination.concurrentPag.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: raintor
 * @Date: 2020/1/26 15:45
 * @Description:
 */
public class MyTask implements Runnable {

    private static final int PAHSE = 5;
    private final CyclicBarrier cyclicBarrier;
    private final CountDownLatch downLatch;
    private final int conten;
    private final static Random RANDOM = new Random(3000);

    public MyTask(CyclicBarrier cyclicBarrier, CountDownLatch downLatch, int conten) {
        this.cyclicBarrier = cyclicBarrier;
        this.downLatch = downLatch;
        this.conten = conten;
    }

    @Override
    public void run() {
        try {
            for(int i = 0;i<PAHSE;i++){
                doPahse(i);
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            downLatch.countDown();
        }
    }

    private void doPahse(int i) {
        String name = Thread.currentThread().getName();
        System.out.println(name +": Begin");
        try {
            Thread.sleep(RANDOM.nextInt(3000));
        } catch (InterruptedException e) {

        }finally {
            System.out.println(name+" : ENd");
        }
    }
}
