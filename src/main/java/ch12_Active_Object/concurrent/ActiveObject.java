package ch12_Active_Object.concurrent;

import java.util.concurrent.Future;

/**
 * @author: raintor
 * @Date: 2020/1/31 20:38
 * @Description:
 * 采用concurrent包中相关的类来实现
 * 并且给主动对象添加了shutdown方法
 */
public interface ActiveObject {
    Future<String> makeString(int count,char fillchar);
    void displauString(String s);
    void shutdown();
}
