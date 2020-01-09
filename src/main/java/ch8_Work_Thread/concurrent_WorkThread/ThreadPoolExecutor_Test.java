package ch8_Work_Thread.concurrent_WorkThread;

import java.util.concurrent.*;

/**
 * @author: raintor
 * @Date: 2020/1/9 15:17
 * @Description:
 */
public class ThreadPoolExecutor_Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,1000l, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10));

        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService1 = Executors.newFixedThreadPool();
    }
}
