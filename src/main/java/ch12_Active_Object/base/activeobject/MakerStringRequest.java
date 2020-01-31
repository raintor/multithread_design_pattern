package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:29
 * @Description:
 * 具体的请求类
 */
public class MakerStringRequest extends MethodRequest<String> {
    private final int count;
    private final char fillchar;

    public MakerStringRequest(Servant servant, FutureResult<String> futureResult, int count, char fillchar) {
        super(servant, futureResult);
        this.count = count;
        this.fillchar = fillchar;
    }

    @Override
    public void execute() {
        //该具体的请求类主要实现的是生产字符串，代用实际的主动对象的方法来实现。
        //返回是实际的RealResult，这里需要将结果设置大Future中。
        Result<String> result = servant.makeString(count,fillchar);
        futureResult.setResult(result);
    }
}
