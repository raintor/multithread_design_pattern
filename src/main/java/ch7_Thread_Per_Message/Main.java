package ch7_Thread_Per_Message;

/**
 * @author: raintor
 * @Date: 2019/10/17 14:58
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main");
        Host host = new Host();
        host.request(10,'a');
        host.request(20,'b');
        host.request(30,'c');
        System.out.println("main end");
    }
}
