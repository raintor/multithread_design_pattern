package ch9_Future.handle_exception.strategy_1;

import ch9_Future.base.RealData;

import java.util.concurrent.ExecutionException;

/**
 * @author: raintor
 * @Date: 2020/1/16 21:02
 * @Description:
 * 采用不使用FutureTask的方法
 * 在FutureData类中设置捕获异常信息的方法
 */
public class Host {
    public Data request(int count,char c){
        System.out.println("request start");

        FutureData futureData = new FutureData();

        new Thread(){
            @Override
            public void run() {
                try {
                    RealData realData = new RealData(count, c);
                    futureData.setRealData(realData);

                }catch (Exception e){//当发生异常时，捕获异常信息后调用设置异常的方法。
                    futureData.setExecutionException(e);
                }
            }
        }.start();

        System.out.println("request end");

        return futureData;
    }
}
