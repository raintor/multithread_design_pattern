package ch2_Immutable;

/**
 * @author: raintor
 * @Date: 2019/9/25 14:05
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alias","aldaldada");

        PrintThread print1 = new PrintThread(person);
        PrintThread print2 = new PrintThread(person);
        print1.start();
        print2.start();
    }
}
