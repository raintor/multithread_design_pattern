package ch4_Balking.ch41_overtime_check;

import ch3_Guarded_Suspension.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: raintor
 * @Date: 2019/10/7 23:29
 * @Description:
 * 给wait添加超时检查功能，超时时间为30s
 * 这里添加的超时，必须为当等待超过30s抛出异常
 */
public class RequestQueue1 {
    private static final long TIMEOT = 30000L;

    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest(){
        //这里定时为进入while之后就进行定时检查，主要的目标就是超时30s抛出异常
        long start = System.currentTimeMillis();
        while (queue.peek() == null){
            long now = System.currentTimeMillis();
            long req = TIMEOT - (now-start);
            if(req<=0){
                throw new LiveNessException("thrown by "+Thread.currentThread().getName());
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        notifyAll();
    }
}
