package ch1_Single_Thread_Execution.ch11_Dead_Lock;

/**
 * @author: raintor
 * @Date: 2019/9/24 16:48
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Tool spoon = new Tool("spoon");
        Tool fork = new Tool("fork");
        new EaterThread("Alice",spoon,fork).start();
        new EaterThread("bob",fork,spoon).start();

    }
    /**
     * 多线程下，工具拿取顺序（也就是这里锁获取的顺序）不一致，就会产生死锁问题；
     * 解决方式有：
     * 1：两者获取资源的顺序一致
     * 2：一次性获取所有资源。
     */
}
