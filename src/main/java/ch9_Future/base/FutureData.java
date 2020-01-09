package ch9_Future.base;

/**
 * @author: raintor
 * @Date: 2020/1/9 18:59
 * @Description:
 * future 模式的提货单类
 */
public class FutureData implements Data {
    private RealData realData;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData){
        if(ready){
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realData.getContent();
    }
}
