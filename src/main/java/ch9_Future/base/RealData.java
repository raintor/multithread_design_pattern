package ch9_Future.base;

/**
 * @author: raintor
 * @Date: 2020/1/9 19:00
 * @Description:
 * 真正的数据，为真实处理之后的返回值
 */
public class RealData implements Data{

    private final String content;

    public RealData(int count,char c) {
        System.out.println("-----making realData("+count+","+c+") begin");
        char[] buffer = new char[count];
        for(int i = 0;i<count;i++){
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("making End");
        this.content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }
}
