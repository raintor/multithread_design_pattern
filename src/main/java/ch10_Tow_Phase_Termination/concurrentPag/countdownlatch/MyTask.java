package ch10_Tow_Phase_Termination.concurrentPag.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author: raintor
 * @Date: 2020/1/26 15:21
 * @Description:
 */
public class MyTask implements Runnable {

    private final CountDownLatch downLatch;
    private final int content;
    private static final Random RANDOM = new Random(3000);

    public MyTask(CountDownLatch downLatch, int content) {
        this.downLatch = downLatch;
        this.content = content;
    }

    @Override
    public void run() {
        doTask();
        downLatch.countDown();
    }

    private void doTask() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " MyTask:Begin, content = "+content);
        try {
            Thread.sleep(RANDOM.nextInt(1000));
        } catch (InterruptedException e) {

        }finally {
            System.out.println(name+" End");
        }
    }

}
