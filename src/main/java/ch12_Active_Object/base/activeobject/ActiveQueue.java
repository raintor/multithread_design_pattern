package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:06
 * @Description:
 * 主动队列为同步队列，主要用于存储实际的请求对象，与p-c，模式中的队列相同
 */
class ActiveQueue {
    //定义最大请求数
    private static final int MAX_REQUEST = 100;
    //定义存储请求的容器
    private final MethodRequest[] requestQueue;

    private int tail;
    private int head;
    private int count;

    public ActiveQueue() {
        requestQueue = new MethodRequest[MAX_REQUEST];
        tail = 0;
        head = 0;
        count = 0;
    }

    public synchronized void putRequset(MethodRequest request){
        while (count>=requestQueue.length){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        requestQueue[tail] = request;
        tail = (tail+1)%requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized MethodRequest getRequest(){
        while (count<=0){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        MethodRequest request = requestQueue[head];
        head = (head+1)%requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}