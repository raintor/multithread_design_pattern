package ch8_Work_Thread.base;

/**
 * @author: raintor
 * @Date: 2020/1/7 15:59
 * @Description:  工作线程，相当于消费者
 */
public class WorkerThread extends Thread {
    private final Channle channle;

    public WorkerThread(String name,Channle channle) {
        super(name);
        this.channle = channle;
    }

    @Override
    public void run() {
        while (true){
            Request request = channle.takeRequest();
            request.execute();
        }
    }
}
