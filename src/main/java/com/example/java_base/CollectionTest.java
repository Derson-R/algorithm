package com.example.java_base;

import com.example.pojo.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionTest {
    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();
        User user = new User("q","18");
        User user2 = new User("q","13");
        User user3 = new User("q","15");
        objects.add(user);
        objects.add(user2);
        //没有重写hashcode值说明是不同的对象，User重写hashcode跟equal说明是不同的对象
        System.out.println(user.equals(user2));
        //说明对象的引用不一样
        System.out.println(user == user2);
        //User没有重写hashcode跟equals方法前，这两个值是不一样的;重新写后两个hashcode的值是一样了
        System.out.println(objects.size());

        /**
         * list集合遍历
         * 1、list集合一边遍历，一边删除的，不能for循环直接remove
         * 2、
         */

        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(user);
        arrayList.add(user2);
        arrayList.add(user3);
        Collections.sort(arrayList, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                //按照顺序排查
                return u1.getAge().compareTo(u2.getAge());
            }
        });
        System.out.println(arrayList.get(0).getAge() + " " + arrayList.get(1).getAge() + " " +arrayList.get(2).getAge());

        Iterator iterator = arrayList.iterator();
        ListIterator iterator1 = arrayList.listIterator();
        while (iterator1.hasNext()){
            arrayList.get(0);
        }
        /**
         * hashMap
         * 1.基本数据结构
         * 2.线程安全
         * 3.死循环
         */
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>(32);


    }
}
