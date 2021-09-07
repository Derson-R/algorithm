package com.example.algorithm.test;

import com.example.algorithm.sort.senior.Merge;
import com.example.algorithm.sort.senior.Quick;
import com.example.algorithm.sort.senior.Shell;
import com.example.algorithm.sort.simple.Insertion;
import com.example.pojo.Drink;
import com.example.pojo.User;
import org.thymeleaf.util.ListUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author desener
 * @date 2021-09-0610:36
 **/
public class TestComparable {

    public static void main(String[] args) throws Exception{
        /*Drink drink1 = new Drink("农夫山泉", 550);
        Drink drink = new Drink("百世可乐", 220);
        Drink drink2 = new Drink("cool", 330);
        Drink drink3 = new Drink("勇穿天涯", 500);

        System.out.println(getMax(drink1, drink2));

        User user1 = new User("张三","18",175);
        User user2 = new User("李四","17",164);
        User user3 = new User("王五","20",176);
        User user4 = new User("赵六","18",180);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        System.out.println(sortUser(users).toString());*/


        /*
         *  测试希尔排序跟插入排序的效率
         *
         * */
        //1、创建一个ArrayList集合，保存读取的数据
        ArrayList<Integer> integers = new ArrayList<>();

        //创建一个缓存读取流BufferReader,读取数据，并缓存到ArrayList中
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(new File("F:\\git_repo\\algorithm\\src\\main\\java\\com\\example\\algorithm\\test\\test.txt"))));
        String line = null;
        while ((line= bufferedReader.readLine())!= null){
            int i = Integer.parseInt(line);
            integers.add(i);
        }
        bufferedReader.close();//关闭流

        //把ArrayList转换成数组
        Integer[] a = new Integer[integers.size()];
        integers.toArray(a);

        //测试排序
        //testInsertion(a);  //insertion排序执行时间：46566毫秒
        //testShell(a);  //shell排序执行时间：43毫秒
        //testMerge(a); //merge排序执行时间：87毫秒
        testQuick(a);

        //上面两个排序的量级差了差不多 1000倍



    }

    //实现Comparable包接口的操作方法
    public static Comparable getMax(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        return result >= 0 ? c1 : c2;
    }

    //多字段排序
    public static List<User> sortUser(List<User> users) {

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                int ageSort = user.getAge().compareTo(t1.getAge());
                if (ageSort > 0) {
                    return 1;
                } else if (ageSort < 0) {
                    return -1;
                } else {
                    int highSort = user.getHigh() - t1.getHigh();
                    return highSort >= 0 ? 1 : -1;
                }
            }
        });
        return users;
    }

    public static void testShell(Integer[] a){
        long startTime = System.currentTimeMillis();
        Shell.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("shell排序执行时间："+(endTime-startTime) +"毫秒");
    }

    public static void testInsertion(Integer[]a){
        long startTime = System.currentTimeMillis();
        Insertion.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("insertion排序执行时间："+(endTime-startTime) +"毫秒");
    }
    public static void testMerge(Integer[] a){
        long startTime = System.currentTimeMillis();
        Merge.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("merge排序执行时间："+(endTime-startTime) +"毫秒");
    }

    public static void testQuick(Integer[] a){
        long startTime = System.currentTimeMillis();
        Quick.sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("quick排序执行时间："+(endTime-startTime) +"毫秒");
    }



}
