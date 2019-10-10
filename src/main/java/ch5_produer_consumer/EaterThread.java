package ch5_produer_consumer;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2019/10/10 12:47
 * @Description:
 */
public class EaterThread extends Thread {
    private final Table table;
    private final Random random;

    public EaterThread(String name,Table table,long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);

    }

    @Override
    public void run() {
        try {
            while (true){
                table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
