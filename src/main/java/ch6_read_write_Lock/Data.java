package ch6_read_write_Lock;

import java.util.concurrent.TimeUnit;

/**
 * @author: raintor
 * @Date: 2019/10/15 15:13
 * @Description:
 * 该类用于表示共享变量，用于共享的数据
 */
public class Data {
    private final char[] buffer;
    private final ReadWriteLock readWriteLock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        //初始化数组中存放的是*
        for(int i = 0;i<size;i++){
            buffer[i] = '*';
        }
    }

    //对于Data的操作，提供了read和write方法
    public char[] read() throws InterruptedException {
        readWriteLock.readlock();
        try {
            return doRead();
        }finally {
            readWriteLock.readunlock();
        }
    }

    public void write(char c){
        readWriteLock.writelock();
        try {
            doWrite(c);
        }finally {
            readWriteLock.writeunlock();
        }
    }

    private void doWrite(char c) {
        for(int i = 0;i<buffer.length;i++){
            buffer[i] = c;
            slowly();       //模仿写时间比读时间长
        }
    }

    private char[] doRead() {
        char[] newChar = new char[buffer.length];
        for(int i = 0;i<buffer.length;i++){
            newChar[i] = buffer[i];
        }
        slowly();
        return newChar;
    }

    private void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
