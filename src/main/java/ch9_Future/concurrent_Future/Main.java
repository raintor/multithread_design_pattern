package ch9_Future.concurrent_Future;

import ch9_Future.base.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2020/1/16 16:55
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Host2 host = new Host2();

        Data a = host.request(10, 'A');
        Data b = host.request(20, 'B');
        Data c = host.request(30, 'c');
        System.out.println("do other things");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {

        }
        System.out.println("other things end");
        System.out.println(a.getContent());
        System.out.println(b.getContent());
        System.out.println(c.getContent());
    }
}
