package ch10_Tow_Phase_Termination.concurrentPag.cyclicbarrier;

import java.util.concurrent.*;

/**
 * @author: raintor
 * @Date: 2020/1/26 15:30
 * @Description:
 * 5组任务，每组3个线程执行，只有全部执行完一组后才可以执行下一组任务
 */
public class Main {
    //定义线程个数
    private static final int THREADS = 3;

    public static void main(String[] args) {
        System.out.println("Main :Begin");
        ExecutorService service = Executors.newFixedThreadPool(THREADS);
        //定义每一组的屏障
        CyclicBarrier barrier = new CyclicBarrier(THREADS, new Runnable() {

            //定义屏障解除时操作
            @Override
            public void run() {
                System.out.println("Barrier Action End");
            }
        });

        //定义所有结束时的操作
        CountDownLatch downLatch = new CountDownLatch(THREADS);

        try {
            for(int i = 0;i<THREADS;i++){
                service.execute(new MyTask(barrier,downLatch,i));
            }
            System.out.println("Wait");
            downLatch.await();
        } catch (InterruptedException e) {

        }finally {
            service.shutdown();
            System.out.println("Main :ENd");
        }
    }
}
