package com.example.java_base;

import com.example.pojo.User;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;

/**
 * 单例模式
 */
public class Singleton {

    private static Singleton singleton = null;

    //必须私有一个构造方法，不让外部直接使用new 的方法来生成一个对象,只能本对象内部使用
    private Singleton() {
    }

    public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }


    public static void main(String[] args) {
        /**
         * 创建对象的几种方式
         ============================================================================================================
         */
        /*// 1、new关键字
        User user = new User();


        // 2、使用Class类的 newInstance()方法
        try {
            User user2 = (User) Class.forName("com.example.pojo.User").newInstance();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }


        // 3、使用Constructor类的 newInstance()方法 ,在java反射包中
        try {
            Constructor<User> constructor = User.class.getConstructor();
            User user3 = constructor.newInstance();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        //上面2、3两种本质就是反射机制


        //4、使用clone方法,前提是被clone 的对象实现了Cloneable接口
        try {
            User user4 = (User) user.clone();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }


        //5、使用反序列化, 将文件里面的
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
            User user5 = (User) in.readObject();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }*/

        /**
         * 对象比较
         ============================================================================================================
         参考详细讲解：https://blog.csdn.net/qq_36090463/article/details/81102713
         */

        /*使用 == 和 equals
        == ：判断两个对象的地址是否相等。比较其内存地址
        equlas：作用是比较两个对象是否相等，存在两种情况
         　　情况1：类没有覆盖重写equals方法，则使用的是父类 Object 的 equals 方法。即通过 “==” 比较两个对象内存地址。
         　　情况2：如果覆盖重写了equals方法，一般，比较两个对象的内容是否相等。*/

        User user6 = new User("q","18",180);
        User user7 = new User("q","18",175);
        //上面两个本质就是不同的对象，所以下面返回的都是 false; 但是重写 User的equals方法，可以人为使这两个对象相等。


        //比较的是不是同一个对象
        System.out.println(user6.equals(user7));
        //比较对象的应用地址
        System.out.println(user6 == user7);

        //没有重写，hashCode的值是不一致的；重写hashCode值，hashCode值一样
        System.out.println(user6.hashCode());
        System.out.println(user7.hashCode());

        //为什么重写equals方法，也要把hashCode方法也要重写了？？
        //一般重写equals是为了保证业务上属性一致的对象比较是要相等的，比如HashSet存放都是通过hashCode来比较对象是否一致，
        //如果两个对象属性是一致的，没有重写hashCode方法，hashCode值不一致，HashSet会把这两个对象都存在表中，这与我们想在Set中存放不同业务对象初衷相违背

    }


}
