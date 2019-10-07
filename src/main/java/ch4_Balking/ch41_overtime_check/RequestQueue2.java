package ch4_Balking.ch41_overtime_check;

import ch3_Guarded_Suspension.Request;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/10/7 23:36
 * @Description:
 */
public class RequestQueue2 {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();
    public Request getRequest(){
        Request req = null;
        try {
//            req = queue.take();
            req = queue.poll(30L, TimeUnit.SECONDS);
            if(req == null){
                throw new LiveNessException("thrown by "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return req;
    }

    public void putRequest(Request request){
        try {
//            queue.put(request);
            boolean req = queue.offer(request,30L,TimeUnit.SECONDS);
            if(!req){
                throw new LiveNessException("thrown by "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
