package com.example.java_base;

/**
 * 线程相关
 */
public class Thread {
    public static void main(String[] args) {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("a");
    }
}
