package ch4_Balking.ch41_overtime_check;

/**
 * @author: raintor
 * @Date: 2019/10/7 23:32
 * @Description:
 */
public class LiveNessException extends RuntimeException {
    public LiveNessException(String message) {
        super(message);
    }
}
