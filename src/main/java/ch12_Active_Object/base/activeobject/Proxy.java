package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:27
 * @Description:
 * 代理类，将方法调用转成请求类进行存储
 */
class Proxy implements ActiveObject {
    private final ScheduleThread thread;
    private final Servant servant;

    public Proxy(ScheduleThread thread, Servant servant) {
        this.thread = thread;
        this.servant = servant;
    }

    @Override
    public Result<String> makeString(int count, char fillchar) {
        FutureResult<String> futureResult = new FutureResult<>();
        thread.invoke(new MakerStringRequest(servant,futureResult,count,fillchar));
        return futureResult;
    }

    @Override
    public void displayString(String s) {
        thread.invoke(new DisplayStringRequest(servant,s));
    }
}
