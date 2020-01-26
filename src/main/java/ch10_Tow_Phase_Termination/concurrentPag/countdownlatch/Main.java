package ch10_Tow_Phase_Termination.concurrentPag.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: raintor
 * @Date: 2020/1/26 15:12
 * @Description:
 * 执行10项任务，等所有任务执行完成以后再结束
 */
public class Main {
    //定义工作数目
    private static final int Task = 10;

    public static void main(String[] args) {
        System.out.println("Main : Begin");
        //定义线程池
        ExecutorService service  = Executors.newFixedThreadPool(5);
        CountDownLatch donwLatch = new CountDownLatch(Task);
        try {
            //开始工作
            for(int i = 0;i<Task;i++){
                service.execute(new MyTask(donwLatch,i));
            }
            System.out.println("Wati");
            donwLatch.await();
        } catch (InterruptedException e) {

        }finally {
            service.shutdown();
            System.out.println("Main : End");
        }
    }
}
