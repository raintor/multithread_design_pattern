package ch12_Active_Object.concurrent;

/**
 * @author: raintor
 * @Date: 2020/1/31 21:07
 * @Description:
 */
public class DisplayClientThread extends Thread {
    private final ActiveObject activeObject;

    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try {
            for(int i = 0;true;i++){
                String s = Thread.currentThread().getName()+" "+i;
                activeObject.displauString(s);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
