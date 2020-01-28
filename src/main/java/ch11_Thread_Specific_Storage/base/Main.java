package ch11_Thread_Specific_Storage.base;

/**
 * @author: raintor
 * @Date: 2020/1/27 20:57
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        new ClientThread("Aliece").start();
        new ClientThread("Bob").start();
        new ClientThread("Chries").start();
    }
}
