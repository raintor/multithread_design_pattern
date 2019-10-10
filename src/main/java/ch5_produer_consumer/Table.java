package ch5_produer_consumer;

/**
 * @author: raintor
 * @Date: 2019/10/10 10:53
 * @Description:
 */
public class Table {
    private final String[] buffer;
    private int tail;   //下一次放蛋糕的位置
    private int head;   //下一次取蛋糕的位置
    private int count;  //每次可以放入蛋糕最大个数

    public Table( int count) {
        this.buffer = new String[count];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
    }

    /**
     * 放入蛋糕
     * @param cake
     * @throws InterruptedException
     */
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" put "+cake);
        while (count>=buffer.length){
            wait();
        }
        buffer[tail] = cake;
        tail = (tail+1)%buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count<=0){
            wait();
        }
        String cake = buffer[head];
        head = (head+1)%buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" take "+cake);

        return cake;
    }
    //添加clear方法，用于清空桌子
    public synchronized void clear(){
        //打印清除信息
        while (count>0){
            String cake = buffer[head];
            System.out.println(Thread.currentThread().getName()+" clear "+cake);
            head = (head+1)%buffer.length;
            count--;
        }
        //清除桌面，就是所有信息置位0；
        count = 0;
        head = 0;
        tail = 0;
        notifyAll();
        /**
         * 注意：这里一定要notifyAll,否则put的线程可能会一直阻塞。
         */
    }
}
