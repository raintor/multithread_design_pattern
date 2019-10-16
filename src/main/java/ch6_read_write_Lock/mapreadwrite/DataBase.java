package ch6_read_write_Lock.mapreadwrite;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: raintor
 * @Date: 2019/10/16 19:37
 * @Description:
 * 对于HashMap，使用读写锁来提升put和get效率
 */
public class DataBase {
    private final HashMap<String, String> map = new HashMap<>();

    //采用concurrent包中的读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readlock = readWriteLock.readLock();
    private final Lock writelock = readWriteLock.writeLock();

    //清除----写
    public void clear(){
        writelock.lock();
        try {
            verySlow();
            map.clear();
        }finally {
            writelock.unlock();
        }
    }

    //分配---写
    public void put(String k,String v){
        writelock.lock();
        try {
            verySlow();
            map.put(k,v);
        }finally {
            writelock.unlock();
        }
    }

    //获取---读
    public String get(String k){
        readlock.lock();
        try {
            String s = map.get(k);
            return s;
        }finally {
            readlock.unlock();
        }
    }

    private void verySlow() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void slow(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过对map类型的读写的读写锁控制效率，可以看出，读写锁本质上是一直读写互斥的锁，目的是为了
     * 减少某一种并发操作繁重操作而设置的。
     * 在这里，map的get操作，并发操作是安全的，因此就采用读锁去控制他，这样的话，提高效率。
     * 通过这样的方法，我们可以知道：
     *      对于多种类型的操作，在并发情况下，一定要总其中规律与状态，合理的设置锁的类型，提高并发效率。
     *
     *
     *  在加锁的这里，使用的是before-after模式，将加锁放到try之外。
     */
}
