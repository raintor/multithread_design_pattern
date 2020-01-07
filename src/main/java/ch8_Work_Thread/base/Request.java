package ch8_Work_Thread.base;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2020/1/7 15:22
 * @Description:
 */
public class Request {
    private final String name;
    private final int number;
    private static final Random RANDOM = new Random();
    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName()+" execute "+this);
        try {
            Thread.sleep(RANDOM.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
