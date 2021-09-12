package com.example.java_base;

import com.example.pojo.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author desener
 * @date 2021-09-07 9:11
 *
 * 相关点 ：
 * 序列化（serializable , externalizable） 、transient关键字
 * IO流 、
 **/
public class JavaIO {

    //把对象User写入
    public static void writeInText() throws FileNotFoundException, IOException {
        /*User user1 = new User("小艾", "18", 165);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(new FileOutputStream("F:\\git_repo\\algorithm\\src\\main\\java\\com\\example\\java_base\\iotest.txt"));
        objectOutputStream.write(user1);
        objectOutputStream.close();*/
    }
}
