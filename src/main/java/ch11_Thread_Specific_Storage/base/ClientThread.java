package ch11_Thread_Specific_Storage.base;

/**
 * @author: raintor
 * @Date: 2020/1/27 20:53
 * @Description: 具体的线程类
 */
public class ClientThread extends Thread {

    public ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + "Begin");
        for (int i = 0; i < 10; i++) {
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.close();
        System.out.println(getName() + "End");
    }
}
