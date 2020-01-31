package ch12_Active_Object.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: raintor
 * @Date: 2020/1/31 21:04
 * @Description:
 */
public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerClientThread(String name, ActiveObject activeObject, char fillchar) {
        super(name);
        this.activeObject = activeObject;
        this.fillchar = fillchar;
    }

    @Override
    public void run() {
        try{
            for(int i = 0;true;i++){
                Future<String> stringFuture = activeObject.makeString(i, fillchar);
                Thread.sleep(10);
                String s = stringFuture.get();
                System.out.println(s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
