package ch9_Future.base;

/**
 * @author: raintor
 * @Date: 2020/1/9 19:05
 * @Description:
 * 该类是用于创建提货单的类，相当于蛋糕店，用于接受订单并返回凭证
 * 主要做一下三件事
 * （1）创建futureData对象
 * （2）创建新的线程，创建RealData实例
 * （3）返回futureData
 */
public class Host {
    public Data request(int count,char c){
        System.out.println("request begin");
        //接受订单
        FutureData futureData = new FutureData();

        //交给面包店做
        new Thread(){
            @Override
            public void run() {
                RealData realData = new RealData(count,c);
                futureData.setRealData(realData);
            }
        }.start();
        //给用户凭证
        return futureData;
    }
}
