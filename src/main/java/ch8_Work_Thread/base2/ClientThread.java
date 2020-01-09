package ch8_Work_Thread.base2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * @author: raintor
 * @Date: 2020/1/9 15:39
 * @Description:
 */
public class ClientThread extends Thread {
    private final ExecutorService executorService;
    private static final Random RANDOM = new Random();

    public ClientThread(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request2 request2 = new Request2(getName(),i);
                //ClientThread类，任然是一直发送工作请求，但是此时提交的对象不再是Channel
                //而是直接交给线程池处理。
                executorService.execute(request2);
                Thread.sleep(RANDOM.nextInt(1000));
            }
        } catch (InterruptedException e) {
        }catch (RejectedExecutionException e){
            System.out.println(getName()+" : "+e);
        }
    }
}
