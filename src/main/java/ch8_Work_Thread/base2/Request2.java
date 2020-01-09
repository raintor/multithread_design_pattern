package ch8_Work_Thread.base2;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2020/1/9 15:41
 * @Description:
 */
public class Request2 implements Runnable {
    private final String name;
    private final int num;
    private static final Random RANDOM = new Random();

    public Request2(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" execute "+this);
        try {
            Thread.sleep(RANDOM.nextInt(1000));
        } catch (InterruptedException e) {

        }
    }

    @Override
    public String toString() {
        return "Request2{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
