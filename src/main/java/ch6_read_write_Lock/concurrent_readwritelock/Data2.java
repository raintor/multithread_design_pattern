package ch6_read_write_Lock.concurrent_readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: raintor
 * @Date: 2019/10/15 17:06
 * @Description:
 */
public class Data2 {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readlock = lock.readLock();
    private final Lock writelock = lock.writeLock();

    public Data2(int size) {
        this.buffer = new char[size];
        for(int i = 0;i<size;i++){
            buffer[i] = '*';
        }
    }

    public char[] read(){
        readlock.lock();
        try {
            return doRead();
        }finally {
            readlock.unlock();
        }
    }

    public void write(char c){
        writelock.lock();
        try {
            doWrite(c);
        }finally {
            writelock.unlock();
        }
    }

    private void doWrite(char c) {
        for(int i = 0;i<buffer.length;i++){
            buffer[i] = c;
            slowly();
        }
    }

    private char[] doRead() {
        char[] newbuffer = new char[buffer.length];
        for(int i = 0;i<buffer.length;i++){
            newbuffer[i] = buffer[i];
        }
        slowly();
        return newbuffer;
    }

    private void slowly() {
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
