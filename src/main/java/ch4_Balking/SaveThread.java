package ch4_Balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/10/5 23:17
 * @Description:
 */
public class SaveThread extends Thread {
    private final Data data;

    public SaveThread(Data data,String name) {
        super(name);
        this.data = data;
    }

    //该线程的执行就是一直保存操作，每隔1s
    @Override
    public void run() {
        while (true){
            try {
                data.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
