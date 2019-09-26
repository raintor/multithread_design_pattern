package ch3_Guarded_Suspension;

/**
 * @author: raintor
 * @Date: 2019/9/26 16:58
 * @Description:
 * 请求类，用于封装请求
 */
public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
