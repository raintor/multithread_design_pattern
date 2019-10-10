package ch5_produer_consumer;

/**
 * @author: raintor
 * @Date: 2019/10/10 12:49
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("Maker_1",table,31415).start();
        new MakerThread("Maker_2",table,92653).start();
        new MakerThread("Maker_3",table,58979).start();
        new EaterThread("eater_1",table,32384).start();
        new EaterThread("eater_2",table,62643).start();
        new EaterThread("eater_3",table,38327).start();
    }
}
