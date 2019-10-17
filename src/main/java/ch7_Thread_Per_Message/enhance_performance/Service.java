package ch7_Thread_Per_Message.enhance_performance;

/**
 * @author: raintor
 * @Date: 2019/10/17 20:26
 * @Description:
 */
public class Service {
    public static void service(){
        System.out.print("service");
        for(int i = 0;i<50;i++){
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("done");
    }
}
