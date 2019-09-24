package ch1_Single_Thread_Execution;

/**
 * @author: raintor
 * @Date: 2019/9/24 14:57
 * @Description:
 * 定义用户线程，实际走过门的那个线程。
 */
public class UserThread extends Thread {
    private final String name;
    private final String address;
    private final Gate gate;

    public UserThread(String name, String address, Gate gate) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(name + " BEGIN");
        while (true) {
            gate.pass(name, address);
        }
    }
}
