package ch6_read_write_Lock;

/**
 * @author: raintor
 * @Date: 2019/10/15 16:18
 * @Description:
 */
public class ReaderThread extends Thread{
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true){
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
        }
    }
}
