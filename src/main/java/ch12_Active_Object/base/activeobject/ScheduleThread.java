package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:24
 * @Description:
 * 处理线程
 */
class ScheduleThread extends Thread {
    private final ActiveQueue queue;

    public ScheduleThread(ActiveQueue queue) {
        this.queue = queue;
    }

    //调用方法，就是将请求进行存储，分离调用与执行
    public void invoke(MethodRequest request){
        queue.putRequset(request);
    }

    //线程执行方法，就是从队列中取出请求进行处理
    @Override
    public void run() {
        while (true){
            MethodRequest request = queue.getRequest();
            request.execute();
        }
    }
}
