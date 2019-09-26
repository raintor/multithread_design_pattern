package ch3_Guarded_Suspension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/9/26 17:02
 * @Description:
 * 定义请求的客户端，用于发送请求
 */
public class RequestClient extends Thread {
    private final RequestQueue queue;
    private final Random random;

    public RequestClient(RequestQueue queue,String name, long seed) {
        super(name);
        this.queue = queue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for(int i = 0;i<1000;i++){
            Request request = new Request("No."+i);
            System.out.println(Thread.currentThread().getName()+" request "+request);
            queue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
