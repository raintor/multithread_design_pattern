package ch8_Work_Thread.base;

/**
 * @author: raintor
 * @Date: 2020/1/7 15:41
 * @Description:   存放物品的公共类，相当于一个存放Request的容器
 * 该类负责传递请求以及用于保存工人线程的类
 * 存储请求使用一个队列（环形队列）来实现
 * 工人线程的保存使用一个线程池----自创
 */
public class Channle {
    private static final int MAX_REQUST = 100;
    //定义用于存储request的队列
    private final Request[] requestsQueue;
    private int head; // queue head
    private int tail;// queue tail
    private int count;

    private final WorkerThread[] workerPool;

    //构造函数,定义创建几个worker线程，对存储request的队列进行初始化

    public Channle(int threads) {
        this.requestsQueue = new Request[MAX_REQUST];
        head = 0;
        tail = 0;
        count = 0;
        this.workerPool = new WorkerThread[threads];
        //给每个worker线程命名
        for (int i = 0;i<threads;i++){
            workerPool[i] = new WorkerThread("worker-"+i,this);
        }
    }

    //开启所有工作线程
    public void startThread(){
        for(int i = 0;i<workerPool.length;i++){
            workerPool[i].start();
        }
    }

    /**
     * 定义存储与读取request的方法
     */
    public synchronized void putRequest(Request request){
        while (count>requestsQueue.length){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        requestsQueue[tail] = request;
        tail = (tail+1)%(requestsQueue.length);
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest(){
        while (count<=0){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        Request request = requestsQueue[head];
        head = (head+1)%(requestsQueue.length);
        count--;
        notifyAll();
        return request;
    }
}
