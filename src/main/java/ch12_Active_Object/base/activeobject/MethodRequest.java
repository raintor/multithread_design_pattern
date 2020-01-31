package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:08
 * @Description:
 * 定义请求的泛型，为抽象类
 */
abstract class MethodRequest<T> {
    //由于具体的请求类可能会使用到servant和futureResult，在抽象类中定义
    protected final Servant servant;
    protected final FutureResult<T> futureResult;

    public MethodRequest(Servant servant, FutureResult<T> futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
