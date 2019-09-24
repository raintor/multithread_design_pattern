package ch1_Single_Thread_Execution.ch11_Dead_Lock;

/**
 * @author: raintor
 * @Date: 2019/9/24 16:29
 * @Description:
 */
public class EaterThread extends Thread {
    private final String name;
    private final Tool leftHand;
    private final Tool rightHand;

    public EaterThread(String name, Tool leftHand, Tool rightHand) {
        this.name = name;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    @Override
    public void run() {
        while (true){
            this.eat();
        }
    }

    public void eat() {
        synchronized (leftHand){
            System.out.println(name+" get left hand tool");
            synchronized (rightHand){
                System.out.println(name+" get right hand ,can eat food");
                System.out.println(name+" is eating,yum..yum");
                System.out.println(name+" put down right");
            }
            System.out.println(name + " put down left");
        }
    }
}
