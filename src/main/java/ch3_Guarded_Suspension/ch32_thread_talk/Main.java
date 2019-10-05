package ch3_Guarded_Suspension.ch32_thread_talk;

import ch3_Guarded_Suspension.Request;
import ch3_Guarded_Suspension.RequestQueue;

/**
 * @author: raintor
 * @Date: 2019/10/5 16:03
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue1 = new RequestQueue();
        RequestQueue requestQueue2 = new RequestQueue();
        requestQueue1.putRequest(new Request("hello"));
        new TalkThread(requestQueue1,requestQueue2,"Alice").start();
        new TalkThread(requestQueue2,requestQueue1,"Bob").start();
    }
}
