package ch9_Future.handle_exception.strategy_1;

import ch9_Future.base.RealData;

import java.util.concurrent.ExecutionException;

/**
 * @author: raintor
 * @Date: 2020/1/16 21:38
 * @Description:
 */
public class FutureData implements Data {
    private RealData realData = null;
    private ExecutionException executionException = null;
    private boolean isready = false;

    public synchronized void setRealData(RealData realData){
        if(isready){
            return;
        }
        this.realData = realData;
        this.isready = true;
        notifyAll();
    }

    //设置 设置异常的方法，当捕捉到异常时，在catch中捕捉设置异常。
    //参数类型采用接口类型  Throwable类型，这样能包含很多异常类型。
    public synchronized void setExecutionException(Throwable throwable){
        if(isready){
            return;
        }
        this.executionException = new ExecutionException(throwable);
        this.isready = true;
        notifyAll();
    }

    //这里在client获取值时，如果发现异常信息不为空，则抛出异常。
    @Override
    public synchronized String getContent() throws ExecutionException {
        if(!isready){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if(executionException!=null){
            throw executionException;
        }
        return realData.getContent();
    }
}
