package ch7_Thread_Per_Message.change;

/**
 * @author: raintor
 * @Date: 2019/10/17 20:13
 * @Description:
 * 将开启线程的方式不使用匿名内部类的方式，这里采用内部类的方式
 */
public class Host2 {
    private final Helper helper = new Helper();
    public void request(int count,char c){
        System.out.println("Main start");
        new HelperThread(count,c).start();
        System.out.println("Main end");
    }


    private class Helper{
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

    private class HelperThread extends Thread{
        private final int count;
        private final char c;

        private HelperThread(int count, char c) {
            this.count = count;
            this.c = c;
        }


        @Override
        public void run() {
            helper.handle(count,c);
        }
    }
}
