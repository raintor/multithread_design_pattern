package ch12_Active_Object.base;

import ch12_Active_Object.base.activeobject.ActiveObject;
import ch12_Active_Object.base.activeobject.Result;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:38
 * @Description:
 * 生成字符串的线程
 */
public class MakerStringThread extends Thread{
    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerStringThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillchar = name.charAt(0);
    }

    @Override
    public void run() {
        try{
            for(int i = 0;true;i++){
                //y有返回值
                Result<String> result = activeObject.makeString(i, fillchar);
                Thread.sleep(10);
                String value = result.getResultValue();
                System.out.println(Thread.currentThread().getName()+": value = "+value);
            }
        } catch (InterruptedException e) {

        }
    }
}
