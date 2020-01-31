package ch12_Active_Object.concurrent;

/**
 * @author: raintor
 * @Date: 2020/1/31 20:40
 * @Description:
 * 生产主动对象的工厂，该工厂最终返回ActiveObjectImpl类，为主要实现类
 */
public class ActiveObjectFactory {
    public static ActiveObject creatActiveObject(){
        return new ActiveObjectImpl();
    }
}
