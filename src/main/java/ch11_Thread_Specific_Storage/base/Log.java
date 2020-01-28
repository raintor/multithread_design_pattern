package ch11_Thread_Specific_Storage.base;

/**
 * @author: raintor
 * @Date: 2020/1/27 20:40
 * @Description:
 * 实际的Log类，该类为多线程都会调用的类，每个线程同过该类去保存日志。
 * 所以该类是共享对象，每个线程都会创建自己的TSLog类。为了区别不同线程创建不同的
 * 日志类，所以采用ThreadLocal类去保存不同的线程TSLog对象
 */
public class Log {
    private static final ThreadLocal<TSLog> tsColl = new ThreadLocal<>();

    //根据不同线程获得自己的TSLog对象
    private static TSLog getTSLog(){
        TSLog tsLog = tsColl.get();
        if(tsLog == null){
            //如果为null，说明当前线程并么有获得过TSLog对象
            tsLog = new TSLog(Thread.currentThread().getName()+" log.txt");
            tsColl.set(tsLog);
        }
        return tsLog;
    }

    //写日志方法
    public static void println(String s){
        getTSLog().println(s);
    }

    //关闭
    public static void close(){
        getTSLog().close();
    }
}
