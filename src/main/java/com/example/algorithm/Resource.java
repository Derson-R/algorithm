package com.example.algorithm;

public class Resource {
    private static Resource ourInstance = null;
    //必须私有一个构造方法，不让外部直接使用new 的方法来生成一个对象,只能本对象内部使用
    private Resource() {
    }

    public synchronized static Resource getInstance() {
        if(ourInstance == null){
            ourInstance = new Resource();
        }
        return ourInstance;
    }


}
