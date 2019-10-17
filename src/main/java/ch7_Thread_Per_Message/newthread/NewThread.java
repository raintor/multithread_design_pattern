package ch7_Thread_Per_Message.newthread;

import ch7_Thread_Per_Message.Helper;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/10/17 15:25
 * @Description:
 */
public class NewThread {
    //方式1 new Thread对象

    //方式2 实现Runnable接口

    //方式3 使用ThreadFactory接口中的newThread方法
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public NewThread(ThreadFactory threadFactory, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.threadFactory = threadFactory;
        this.executor = executor;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public void request(int count,char c){
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                helper.handle(count,c);
            }
        }).start();
    }

    /**
     * 使用ThreadFactory接口的中的方法的好处，就是可以控制线程的创建，只需要在构造函数是
     * 传递不同的创建线程类就可以了。
     */

    //4：使用Executors类获取ThreadFactory，这样在3中的构造时，传递
    //Executors.defaultThreadFactory.


    //5.使用Executor接口中的execute方法
    private final Executor executor;
    public void request2(int count,char c){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                helper.handle(count,c);
            }
        });
    }
    /**
     * 使用Executor的execute方法以后，在提交任务时，需要传递Executor。
     * Host host = new Host(
     *      new Executor(){
     *          public void executor(Runnable r){
     *              new Thread(r).start();
     *          }
     *      }
     * );
     */

    //6:上述都是需要创建线程，所以就是，能否存在一种使用空闲线程的方式
    //使用  ExecutorService接口。
    /**
     * 这样在创建Host是，传递进去的Executor可以是ExecutorService接口。
     * 因为ExecutorService是Executor的子接口
     *
     * 可以使用
     * ExecutorService service= Executors.newCachedThreadPool();
     */

    //7:定时执行
    //使用ExecutorService接口的子接口：ScheduleExecutorservice。
    //内部的schedule方法
    //   schedule(Runnable r,long delayTime,TimeUnit unit)
    private final ScheduledExecutorService scheduledExecutorService;

    public void request3(int count ,char c){
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                helper.handle(count,c);
            }
        },10l, TimeUnit.SECONDS);
        //接受到任务之后10s开始
    }
    /**
     * 在传递任务时，构造时使用Executors中的newScheduleThreadPool
     *
     * ScheduleExecutorService service = new newScheduleThreadPool（3）；
     */
}
