package cn.greedystar.springbootdemo.core.exception;

/**
 * 自定义异常
 * Author GreedyStar
 * Date   2018/7/19
 */
public class CustomException extends Exception {

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
