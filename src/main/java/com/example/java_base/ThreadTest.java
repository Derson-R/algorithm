package com.example.java_base;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("a");
    }
}
