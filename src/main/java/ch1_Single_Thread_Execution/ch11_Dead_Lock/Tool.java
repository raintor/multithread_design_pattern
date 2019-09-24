package ch1_Single_Thread_Execution.ch11_Dead_Lock;

/**
 * @author: raintor
 * @Date: 2019/9/24 16:28
 * @Description:
 */
public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                '}';
    }
}
