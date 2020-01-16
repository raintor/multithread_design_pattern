package ch9_Future.concurrent_Future;

import ch9_Future.base.RealData;

import java.util.concurrent.Callable;

/**
 * @author: raintor
 * @Date: 2020/1/16 16:53
 * @Description:
 */
public class Host2 {
    public FutureData2 request(int count,char c){
        System.out.println("request start");
        FutureData2 future = new FutureData2(
                new Callable<RealData>() {
                    @Override
                    public RealData call() throws Exception {
                        return new RealData(count, c);
                    }
                }
        );
        new Thread(future).start();

        System.out.println("request end");

        return future;
    }
}
