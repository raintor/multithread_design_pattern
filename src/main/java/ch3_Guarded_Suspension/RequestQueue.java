package ch3_Guarded_Suspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/9/26 17:00
 * @Description:
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public Request getRequest(){
        synchronized (queue){
            while (queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.remove();
        }
    }

    public void putRequest(Request request){
        synchronized (queue){
            queue.offer(request);
            queue.notifyAll();
        }
    }
    /**
     * 请求队列类，主要用于存储消息，在多线程情况下注意安全性。
     * 使用synchronize同步块，在取出队列时，如果对列为空。则wait
     *
     * 这里符合等待好的条件，就是当添加了消息后，执行notifyAll方法。
     */
}
