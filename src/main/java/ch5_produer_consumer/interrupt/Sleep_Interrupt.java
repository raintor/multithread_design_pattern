package ch5_produer_consumer.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/10/10 18:16
 * @Description:
 */
public class Sleep_Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("start");
            try {
                Thread.sleep(4000);
                System.out.println("go on");
            } catch (InterruptedException e) {
                System.out.println("go to catch");
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
