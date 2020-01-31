package ch12_Active_Object.base.activeobject;

import com.sun.org.glassfish.gmbal.ParameterNames;

/**
 * @author: raintor
 * @Date: 2020/1/30 20:58
 * @Description:
 * 主动对象实际处理的类
 */
class Servant implements ActiveObject {

    /**
     *
     * @param count  字符的个数
     * @param fillchar 字符种类
     * @return
     */
    @Override
    public Result<String> makeString(int count, char fillchar) {
        char[] buffer = new char[count];
        for(int i = 0;i<count;i++){
            buffer[i] = fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        //这里返回实际的Result对象（不是future），应为已经产生的真正的结果
        return new RealResult<String>(new String(buffer));
    }

    @Override
    public void displayString(String s) {
        try {
            System.out.println("displayString : "+s);
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
