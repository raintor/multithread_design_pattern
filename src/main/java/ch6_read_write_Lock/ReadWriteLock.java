package ch6_read_write_Lock;

/**
 * @author: raintor
 * @Date: 2019/10/15 15:13
 * @Description:
 * 读写锁
 */
public class ReadWriteLock {
    private int readingReaders = 0; // 表示正在读取的线程数
    private int waitingWriters = 0; //表示正在等待的写线程数
    private int writingWriters = 0; //表示正在写入的线程数

    private boolean preferWrite = true;  //写入优先，则为true

    public synchronized void readlock() throws InterruptedException {
        while (writingWriters>0||(preferWrite&&waitingWriters>0)){
            wait();
        }
        readingReaders++;
    }

    public synchronized void readunlock(){
        readingReaders--;
        preferWrite = true;
        notifyAll();
    }

    public synchronized void writelock(){
        waitingWriters++;
        try {
            while (readingReaders>0||writingWriters>0){
                wait();
            }
        } catch (InterruptedException e) {
            waitingWriters--;
        }
        writingWriters++;
    }

    public synchronized void writeunlock(){
        writingWriters--;
        preferWrite = false;
        notifyAll();
    }
}
