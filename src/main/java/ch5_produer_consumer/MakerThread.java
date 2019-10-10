package ch5_produer_consumer;

import java.util.Random;

/**
 * @author: raintor
 * @Date: 2019/10/10 11:09
 * @Description:
 */
public class MakerThread extends Thread {
    private final Table table;
    private final Random random;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(random.nextInt(1000));
                String cake = "[ cake No."+nextId()+" by "+getName()+" ] ";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
