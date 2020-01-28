package ch11_Thread_Specific_Storage.test11_3;




/**
 * @author: raintor
 * @Date: 2020/1/28 20:10
 * @Description:
 * 修改的ClientThread类，不再手动调用close方法
 */
public class ClientThread_1 extends Thread{

    public ClientThread_1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + "Begin");
        for (int i = 0; i < 10; i++) {
            Log_1.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Log.close();
        System.out.println(getName() + "End");
    }
}
