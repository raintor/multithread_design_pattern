package ch7_Thread_Per_Message;

/**
 * @author: raintor
 * @Date: 2019/10/17 14:51
 * @Description:
 * 用于处理请求的，创建每个处理线程的类
 */
public class Host {
    private final Helper helper = new Helper();
    public void request(int count,char c){
        System.out.println(" request "+c+"begin");
        new Thread(){
            @Override
            public void run() {
                helper.handle(count,c);
            }
        }.start();
        System.out.println("request "+c+"end");
    }
}
