package ch10_Tow_Phase_Termination.base;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: raintor
 * @Date: 2020/1/17 22:51
 * @Description:
 * 计数线程，内部定义shutdown方法
 */
public class CountupThread extends Thread {
    //计数值
    private int count = 0;

    //终止标志位
    private volatile boolean flag = false;

    //终止方法
    public void  shutdownRequest(){
        flag = true;
        interrupt();
    }

    //线程体

    @Override
    public final void run() {
        try {
            while (!flag) {
                dowork();
            }
        }catch (InterruptedException e){

        }finally {
            shutDown();
            /**
             * 注释：使用shutdown的原因：仅仅设置标志位是不够的。
             * 因为有些线程内部可能正在sleep或者wait，所以此时即使设置了标志位，线程
             * 还是处在等在状态，调用interrupt（）方法，能够使线程跳出sleep或者wait状态。
             */
        }
    }

    private void shutDown() {
        System.out.println("shutdown : count = "+count);
        try {
            FileWriter writer = new FileWriter("count.txt");
            writer.write("count = "+count);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dowork() throws InterruptedException {
        count++;
        System.out.println("dowork: counter = "+count);
        Thread.sleep(500);
    }

}
