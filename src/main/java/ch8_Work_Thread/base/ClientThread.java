package ch8_Work_Thread.base;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2020/1/7 15:15
 * @Description: 用于发送请求的类，该类相当于生产者
 */
public class ClientThread extends Thread {
    private final Channle channle;
    private static final Random RANDOM = new Random();

    public ClientThread(String name,Channle channel) {
        super(name);
        this.channle = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0;true;i++){
                Request request = new Request(getName(),i);
                channle.putRequest(request);
                Thread.sleep(RANDOM.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
