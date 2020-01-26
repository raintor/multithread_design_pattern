package ch10_Tow_Phase_Termination.uncaughtException;

/**
 * @author: raintor
 * @Date: 2020/1/23 21:20
 * @Description:
 * 演示：（1）未捕获异常
 * （2） 退出钩子。
 * （1）未捕获异常采用UncaugthException
 * （2）退出钩子是指java虚拟机在退出时启动的线程，java虚拟机退出有两种情况：
 *      1：调用了System.exit()方法
 *      2：所有非守护线程终止。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main : Begin");

        //(1) 设置未捕获异常
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("******");
                System.out.println("UncaughtException : Begin");
                System.out.println("CurrentThread : "+Thread.currentThread());
                System.out.println("thread : "+t);
                System.out.println("excption : "+e);
                System.out.println("UncaughtException : End");
            }
        });

        //(2)设置退出钩子
        Runtime.getRuntime().addShutdownHook(
                new Thread(){
                    @Override
                    public void run() {
                        System.out.println("&&&&&");
                        System.out.println("shutdown hook : Begin");
                        System.out.println("CurrentThread : "+Thread.currentThread());
                        System.out.println("shutdown hook : End");
                    }
                }
        );

        //(3)大约3秒启动异常
        new Thread("MyTHread"){
            @Override
            public void run() {
                System.out.println("MyThread : Begin");
                System.out.println("Sleep");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {

                }
                System.out.println("Divide");
                //这里异常并没有捕获，会调用默认的异常
                int x = 1/0;

                System.out.println("End");
            }
        }.start();
        System.out.println("Main : End");


    }
}
