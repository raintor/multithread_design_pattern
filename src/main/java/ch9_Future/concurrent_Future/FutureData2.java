package ch9_Future.concurrent_Future;

import ch9_Future.base.Data;
import ch9_Future.base.RealData;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: raintor
 * @Date: 2020/1/16 16:50
 * @Description:
 */
public class FutureData2 extends FutureTask<RealData> implements Data {
    public FutureData2(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getContent() {
        String content = null;
        try {
            content = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return content;
    }
}
