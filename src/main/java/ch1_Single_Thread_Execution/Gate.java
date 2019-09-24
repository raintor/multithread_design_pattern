package ch1_Single_Thread_Execution;

/**
 * @author: raintor
 * @Date: 2019/9/24 14:51
 * @Description:
 *
 * 单纯只使用Gate类，是线程不安全的操作，无法保证一个时刻只有一个人通过这一个门，所以必须保证线程安全
 * 采用线程安全的方式，设计Single Thread
 */
public class Gate {
    private int count = 0;
    private String name = "noone";
    private String address = "nowhere";

    public synchronized void pass(String name,String address){
        count++;
        this.name = name;
        this.address = address;
        System.out.println(this);
    }

    @Override
    public synchronized String toString() {
        return "Gate{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
