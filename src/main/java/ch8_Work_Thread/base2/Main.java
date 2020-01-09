package ch8_Work_Thread.base2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: raintor
 * @Date: 2020/1/9 15:36
 * @Description: 主函数则使用线程池代替工作线程
 */
public class Main {
    public static void main(String[] args) {
        //类似于Channel线程，用于管理workThread，这里直接使用线程池作为workThread的管理工具，直接
        //调用线程池的execute方法执行Request对象，这里要注意的是，如果使用线程池执行Request，必须
        //Request实现Runnable接口。
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            new ClientThread("A", executorService).start();
            new ClientThread("B", executorService).start();
            new ClientThread("C", executorService).start();

            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }finally {
            executorService.shutdown();
        }
    }
}
