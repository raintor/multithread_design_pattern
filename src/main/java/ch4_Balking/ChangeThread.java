package ch4_Balking;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/10/5 23:20
 * @Description:
 * 该线程用于改变并且保存
 */
public class ChangeThread extends Thread{
    private final Data data;
    private final Random random = new Random();
    public ChangeThread(Data data,String name) {
        super(name);
        this.data = data;
    }

    //该线程的方法主要就是每隔一段时间进行修改数据，同时每隔一段时间进行保存
    @Override
    public void run() {
        try {
            for(int i = 0;true;i++){
                data.change("No."+i);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                data.save();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
