package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 20:51
 * @Description:
 * 用于生成主动对象的工厂类，该类用于生成实际的对象
 * 该工厂主要有一个静态方法，返回ActiveObject类。
 * 工厂中主要将p-c模式的相关类进行配置
 * （1）ActiveQueue类---存储请求的类
 * （2）servant类----实际处理的类
 * （3）ScheduleThread类----用于存储于处理的类（线程）
 * （4）proxy类----代理类，将方法调用转换为类
 */
public class ActiveObjectFactory {
    public static ActiveObject createActiveObject(){
        //创建实际的主动对象，用于p-c模式中使用
        Servant servant = new Servant();
        //创建主动队列，用于存储请求
        ActiveQueue queue = new ActiveQueue();
        //定义处理线程
        ScheduleThread thread = new ScheduleThread(queue);
        //定义代理类，该代理类为代理实现，将具体的方法转换成类
        Proxy proxy = new Proxy(thread,servant);
        thread.start();
        return proxy;
    }
}
