package ch7_Thread_Per_Message.enhance_performance;

/**
 * @author: raintor
 * @Date: 2019/10/17 20:27
 * @Description:
 * 调用一个类中windowsFrom方法，该方法是耗时的方法。
 * 这里考虑如何提高响应性，考虑多次调用的情况。
 */
public class Main {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.windowsFrom1();
        myFrame.windowsFrom1();
        myFrame.windowsFrom1();
    }
}
