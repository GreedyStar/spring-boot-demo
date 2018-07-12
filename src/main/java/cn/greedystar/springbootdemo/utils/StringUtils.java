package cn.greedystar.springbootdemo.utils;

/**
 * Author GreedyStar
 * Date   2018/7/11
 */
public class StringUtils {

    public static boolean isBlank(String string) {
        if (string == null || string.length() == 0) {
            return true;
        }
        return false;
    }

}
