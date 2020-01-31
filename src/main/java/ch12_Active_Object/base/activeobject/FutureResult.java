package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:09
 * @Description:
 * 定义future模式的返回值
 */
public class FutureResult<T> extends Result<T> {
    private Result<T> result;
    private boolean ready = false;

    public synchronized void setResult(Result<T> result) {
        this.result = result;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized T getResultValue() {
        if(!ready){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return result.getResultValue();
    }
}
