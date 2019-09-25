package ch2_Immutable.test2_4;

/**
 * @author: raintor
 * @Date: 2019/9/25 19:22
 * @Description:
 * 展示 final类型。没有setter方法，但不是immutable类型
 */
public class UserInfo {
    private final StringBuffer sb;

    public UserInfo(String name,String address) {
        this.sb = new StringBuffer("<info name=\""+name+"\"address+\""+address+"\"/>");
    }

    public StringBuffer getSb(){
        return sb;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sb=" + sb +
                '}';
    }
    /**
     * 因为final修饰的StringBuffer对象，其内部的值是可变的，所以sb被final修饰，其值也会改变。
     */
}
