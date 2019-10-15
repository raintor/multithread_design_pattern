package ch6_read_write_Lock;

/**
 * @author: raintor
 * @Date: 2019/10/15 16:21
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data,"ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriterThread(data,"abcdefghijklmnopqrstuvwxyz").start();
    }
}
