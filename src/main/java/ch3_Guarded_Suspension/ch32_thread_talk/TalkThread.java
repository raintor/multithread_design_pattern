package ch3_Guarded_Suspension.ch32_thread_talk;

import ch3_Guarded_Suspension.Request;
import ch3_Guarded_Suspension.RequestQueue;

/**
 * @author: raintor
 * @Date: 2019/10/5 15:57
 * @Description:
 */
public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;


    public TalkThread(RequestQueue input, RequestQueue output,String name) {
        super(name);
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Begin");
        for(int i = 0;i<20;i++){
            Request request = input.getRequest();
            System.out.println("get "+request);
            Request request1 = new Request(request.getName()+"!!!");
            System.out.println("put "+request1);
            output.putRequest(request1);
        }
        System.out.println(Thread.currentThread().getName()+"END");
    }
}
