package com.example.java_base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.stream.Collectors.toList;

/**
 * 集合流的参考地址
 * https://blog.csdn.net/baidu_38083619/article/details/87891206?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
 */

public class ListDemo {


    public static void main(String[] args) {
        ArrayList<Staff> arrayList = new ArrayList<>();
        arrayList.add(new Staff("测试","女",21));
        arrayList.add(new Staff("开发","男",30));
        arrayList.add(new Staff("运维","男",25));
        arrayList.add(new Staff("DBA","女",27));
        arrayList.add(new Staff("产品","女",29));
        arrayList.add(new Staff("运营","女",29));
        arrayList.add(new Staff("经理","男",33));
        arrayList.add(new Staff("保洁","女",48));



        //System.out.println(arrayList.stream().filter(student -> student.sex.equals("女")).collect(toList()).size());
        /*System.out.println(arrayList.stream().sorted(
                Comparator.comparing(staff -> staff.age)

        ).collect(toList()));*/

        //[21, 30, 25, 27, 29, 29, 33, 48]
        System.out.println(arrayList.stream().map(staff -> staff.age).collect(toList()));

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
