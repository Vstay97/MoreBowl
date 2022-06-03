package edu.xjnu.MoreBowl.common;

/**
 * @author Vstay
 * @date 2022/6/3 下午 10:36
 */

public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
