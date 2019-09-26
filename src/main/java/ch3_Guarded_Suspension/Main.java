package ch3_Guarded_Suspension;

/**
 * @author: raintor
 * @Date: 2019/9/26 19:00
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new RequestClient(queue,"Alice",3141592L).start();
        new RequestServer(queue,"Bob",6535897L).start();
    }
}
