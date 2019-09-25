package ch2_Immutable;

/**
 * @author: raintor
 * @Date: 2019/9/25 14:04
 * @Description:
 */
public class PrintThread extends Thread {
    private final Person person;

    public PrintThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(person.getName()+" : "+person.getAddress());
        }
    }
}
