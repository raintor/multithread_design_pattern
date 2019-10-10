package ch5_produer_consumer.stop_all_running;

import ch5_produer_consumer.EaterThread;
import ch5_produer_consumer.MakerThread;
import ch5_produer_consumer.Table;

import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/10/10 19:34
 * @Description: 与基本的Main
 * 方法类似，启动多生产，多消费；但是不同的是，启动之后，10s后停止所有线程。
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        Thread[] threads = {
                new MakerThread("Maker_1", table, 31415),
                new MakerThread("Maker_2", table, 92653),
                new MakerThread("Maker_3", table, 58979),
                new EaterThread("eater_1", table, 32384),
                new EaterThread("eater_2", table, 62643),
                new EaterThread("eater_3", table, 38327)
        };
        for(int i = 0;i<threads.length;i++){
            threads[i].start();
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0;i<threads.length;i++){
            threads[i].interrupt();
        }
    }
    /**
     * 这里主要注意以下几点：
     * （1）当需要批量的开启和中断线程，此时可以封装线程数组。
     * Thread[] threads = {};
     * （2）这里停止的原理是使用了interrupt方法，抓住了put和take方法内部的sleep方法，由于sleep的while循环在try内部
     * 这样interrupt之后直接跳到catch中，直接跳出了while循环，从而结束所有运行。
     */
}
