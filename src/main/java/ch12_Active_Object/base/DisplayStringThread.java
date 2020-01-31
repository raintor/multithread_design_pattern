package ch12_Active_Object.base;

import ch12_Active_Object.base.activeobject.ActiveObject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:43
 * @Description:
 */
public class DisplayStringThread extends Thread{
    private final ActiveObject activeObject;

    public DisplayStringThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try{
            for(int i = 0;true;i++){
                String  s = Thread.currentThread().getName()+" "+i;
                activeObject.displayString(s);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {

        }
    }
}
