package ch12_Active_Object.base.activeobject;

/**
 * @author: raintor
 * @Date: 2020/1/30 21:35
 * @Description:
 */
public class DisplayStringRequest extends MethodRequest<Object>{
    private final String string;

    public DisplayStringRequest(Servant servant,  String string) {
        super(servant,null);
        this.string = string;
    }

    @Override
    public void execute() {
        servant.displayString(string);
    }
}
