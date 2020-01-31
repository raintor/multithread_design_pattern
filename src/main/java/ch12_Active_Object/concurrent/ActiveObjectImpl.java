package ch12_Active_Object.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: raintor
 * @Date: 2020/1/31 20:42
 * @Description:
 * 该类为主动对象真正的实现类，类似于base包中实现的Servant类一样
 * 这里采用jdk中concurrent包中的类，避免了自己实现Queue、scheduleThread等。
 */
class ActiveObjectImpl implements ActiveObject {
    //这里采用singlethreadexecutor类，代替了schedulethread类，该类的
    //submit方法是带有返回值的，execute方法不带有返回值。
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    public Future<String> makeString(int count, char fillchar) {
        //将方法调用转换为消息的存储，service中自带了同步队列。，关键是自己定义具体消息类型
        //这里定义为内部类
        class MakerStringRequest implements Callable<String>{

            @Override
            public String call() throws Exception {
                char[] buffer = new char[count];
                for(int i = 0;i<count;i++){
                    buffer[i] = fillchar;
                    try {

                        Thread.sleep(100);
                    }catch (InterruptedException e){

                    }
                }
                return new String(buffer);
            }
        }

        return service.submit(new MakerStringRequest());
    }

    @Override
    public void displauString(String s) {
        class DisplayStringRequest implements Runnable{

            @Override
            public void run() {
                System.out.println("display : "+s);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }

        service.execute(new DisplayStringRequest());
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }
}
