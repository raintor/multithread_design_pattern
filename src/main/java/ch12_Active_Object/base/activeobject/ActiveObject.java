package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 20:45
 * @Description: 主动对象的接口
 * 主动对象主要完成两件事：
 * （1）字符串的生成
 * （2）字符串的显示
 * 所以主动对象有这两个行为。
 * 由于是异步，字符串生成返回是Future模式
 */
public interface ActiveObject {
    Result<String> makeString(int count, char fillchar);

    void displayString(String s);
}
