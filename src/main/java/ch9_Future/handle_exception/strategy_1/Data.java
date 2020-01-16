package ch9_Future.handle_exception.strategy_1;

import java.util.concurrent.ExecutionException;

/**
 * @author: raintor
 * @Date: 2020/1/16 21:37
 * @Description:
 */
public interface Data {
    String getContent() throws ExecutionException;
}
