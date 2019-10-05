package ch4_Balking;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: raintor
 * @Date: 2019/10/5 23:12
 * @Description:
 * 用于描述数据的类
 */
public class Data {
    private final String filename;//保存的文件名
    private String content;//保存的内容
    private boolean ischange;//标志位，用于判断是否改变

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.ischange = true;
    }

    //修改数据内容
    public synchronized void change(String newcontent){
        content = newcontent;
        ischange = true;
    }

    //保存数据
    public synchronized void save() throws IOException {
        if(!ischange){
            System.out.println(Thread.currentThread().getName()+" find balk");
            return;
        }
        dosave();
        ischange = false;
    }

    private void dosave() throws IOException {
        System.out.println(Thread.currentThread().getName()+" calls dosave,content"+content);
        //写入文件中
        FileWriter fw = new FileWriter(filename);
        fw.write(content);
        fw.close();
    }
}
