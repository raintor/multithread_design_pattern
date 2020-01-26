package ch10_Tow_Phase_Termination.base;

/**
 * @author: raintor
 * @Date: 2020/1/17 22:57
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main : Begin");


        try {
            CountupThread countupThread = new CountupThread();
            countupThread.start();

            Thread.sleep(10000);

            System.out.println("main : shutdown");
            countupThread.shutdownRequest();

            System.out.println("main : join");
            countupThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main : END");
    }
}
