package ch11_Thread_Specific_Storage.test11_3;

import ch11_Thread_Specific_Storage.base.TSLog;

/**
 * @author: raintor
 * @Date: 2020/1/28 20:14
 * @Description:
 * 重写的Log类，添加监测线程
 */
public class Log_1 {

    private final static ThreadLocal tsColl = new ThreadLocal();

    //获取TSLog类
    private static TSLog getTsLog(){
        TSLog tsLog = (TSLog) tsColl.get();

        if(tsLog == null){
            tsLog = new TSLog(Thread.currentThread().getName() + " log.txt");
            tsColl.set(tsLog);
            //这里修改为：启动监测，即监测当前任务完成情况来决定是否需要关闭流
            //@parame : tslog   : 传递的是当前被监测线程的TsLog对象，用于关闭当前线程的流
            startWatcher(tsLog);
        }

        return tsLog;
    }

    private static void startWatcher(TSLog tsLog) {
        //获取当前被监测的线程
        Thread targetThread = Thread.currentThread();

        //启动当前监测线程，关闭流的标志是当前线程已经结束，那么如何判断已经结束了呢？
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("startWatcher : "+ targetThread.getName()+" Begin");
                try {
                    //这里采用的判断标志是，采用当前线程的join方法，这样监测线程就会等待
                    //当前线程的结束才会继续执行.
                    targetThread.join();
                } catch (InterruptedException e) {

                }
                tsLog.close();
                System.out.println(" startwatch : "+targetThread.getName()+" end");
            }
        };
        t.start();
    }

    //写日志
    public static void println(String s){
        getTsLog().println(s);
    }

    //关闭日志
    public static void close(){
        getTsLog().close();
    }

}
