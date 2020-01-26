package ch10_Tow_Phase_Termination.uncaughtException;

/**
 * @author: raintor
 * @Date: 2020/1/23 21:13
 * @Description:
 */
public class MyUncaughtHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("get exception "+e.getMessage());
    }
}
