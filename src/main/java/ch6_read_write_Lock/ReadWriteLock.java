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

    /**
     * 这里的preferwrite是非常有必要的
     * 在读多写少的情况下，如果仅仅凭write的数目>0来控制read，由于read-read是不会加锁的，这样就会产生
     * “死读”现象，就是出于一直读的状态，这样读写不平衡，因此通过waitwrite的数目和标志位控制读的程度。
     */
}
