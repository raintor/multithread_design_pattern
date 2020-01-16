package ch9_Future.handle_exception.strategy_2;

import ch9_Future.base.RealData;
import ch9_Future.handle_exception.strategy_1.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: raintor
 * @Date: 2020/1/16 21:53
 * @Description:
 * 使用FutureData继承FutureTask类，这样FutureData就可以使用FutureTask 的set异常方法
 * 这样不必自己写，而且可以很好的管理。
 */
public class FutureData extends FutureTask<RealData> implements Data {
    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getContent() throws ExecutionException {
        String content = null;
        try {
            content = get().getContent();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return content;
    }

}
