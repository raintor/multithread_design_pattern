package ch3_Guarded_Suspension;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2019/9/26 18:57
 * @Description:
 * 用于接受请求信息。
 */
public class RequestServer extends Thread {
    private final RequestQueue queue;
    private final Random random;

    public RequestServer(RequestQueue queue,String name, long seed) {
        super(name);
        this.queue = queue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for(int i = 0;i<1000;i++){
            Request request = queue.getRequest();
            System.out.println(Thread.currentThread().getName()+" handles "+request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
