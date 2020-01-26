package ch10_Tow_Phase_Termination.uncaughtException;

/**
 * @author: raintor
 * @Date: 2020/1/23 21:11
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtHandler());
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("345"));
        System.out.println(Integer.parseInt("ASD"));
//        MyUncaughtHandler m = new MyUncaughtHandler();
    }
}
