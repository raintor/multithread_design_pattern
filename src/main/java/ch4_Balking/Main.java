package ch4_Balking;

/**
 * @author: raintor
 * @Date: 2019/10/5 23:24
 * @Description:
 * 主线程
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("balk.txt","NUN");
        new ChangeThread(data,"changeThread").start();
        new SaveThread(data,"SavaThread").start();
    }
}
