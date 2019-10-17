package ch7_Thread_Per_Message;

/**
 * @author: raintor
 * @Date: 2019/10/17 14:52
 * @Description:
 * 工具类，一种具体的任务
 */
public class Helper {
    public void handle(int count,char c){
        System.out.println("  handle("+count+","+c+"),Begin");
        for(int i = 0;i<count;i++){
            slowy();
            System.out.print(c);
        }
        System.out.println("");
        System.out.println("  handle("+count+","+c+"),End");
    }

    private void slowy() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
