package ch8_Work_Thread.base;

/**
 * @author: raintor
 * @Date: 2020/1/7 16:16
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Channle channle = new Channle(5);
        channle.startThread();
        new ClientThread("A",channle).start();
        new ClientThread("B",channle).start();
        new ClientThread("C",channle).start();
    }
}
