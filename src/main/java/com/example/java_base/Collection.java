package com.example.java_base;

import com.example.pojo.User;
import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;

/**
 * 集合相关
 */
public class Collection {
    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();
        User user = new User("q","18",175);
        User user2 = new User("q","13",175);
        User user3 = new User("q","15",175);
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
         * 2、集合流的地址：https://blog.csdn.net/baidu_38083619/article/details/87891206?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
         */

       /* ArrayList<User> arrayList = new ArrayList<>();
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
        }*/

        ArrayList<Collection.Staff> arrayList = new ArrayList<>();
        arrayList.add(new Collection.Staff("测试","女",21));
        arrayList.add(new Collection.Staff("开发","男",30));
        arrayList.add(new Collection.Staff("运维","男",25));
        arrayList.add(new Collection.Staff("DBA","女",27));
        arrayList.add(new Collection.Staff("产品","女",29));
        arrayList.add(new Collection.Staff("运营","女",29));
        arrayList.add(new Collection.Staff("经理","男",33));
        arrayList.add(new Collection.Staff("保洁","女",48));

        //System.out.println(arrayList.stream().filter(student -> student.sex.equals("女")).collect(toList()).size());
        /*System.out.println(arrayList.stream().sorted(
                Comparator.comparing(staff -> staff.age)

        ).collect(toList()));*/

        //[21, 30, 25, 27, 29, 29, 33, 48]
        System.out.println(arrayList.stream().map(staff -> staff.age).collect(toList()));

        /**
         * hashMap
         * 1.基本数据结构
         * 2.线程安全
         * 3.死循环
         */
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>(32);


    }

    @Data
    static class Staff{
        String name;
        String sex;
        Integer age;

        public Staff(String name, String sex, Integer age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
    }
}
