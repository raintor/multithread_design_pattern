package ch11_Thread_Specific_Storage.base;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: raintor
 * @Date: 2020/1/27 20:32
 * @Description:
 * 每个线程特有的Log类，该类定义了具体的保存日志的方法
 */
public class TSLog {
    private PrintWriter writer = null;

    //初始化
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //写日志
    public void println(String s){
        writer.println(s);
    }

    //关闭
    public void close(){
        writer.println("====End of log====");
        writer.close();
    }


}
