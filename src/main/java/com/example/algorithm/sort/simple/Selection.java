package com.example.algorithm.sort.simple;

import java.util.Arrays;

/**
 * @author desener
 * @date 2021-09-06 14:08
 *
 * 选择排序：1、每次遍历都假定第一个位置的元素值最小，然后跟其他位置的值进行比较，如果当前索引位置的值小，那么就假定最小值为该索引处
 *              ，按照前面方法比较一次循环结束，找到最小值所在的索引值；
 *           2、交换第一个索引处和最小值所在索引处的值；
 *
 *  API设计：1、构造方法
 *           2、排序 sort() ; 比较greater()； 交换exch();
 **/
public class Selection {

    public static void main(String[] args) {
        Integer[] a = {8, 4, 2, 6, 1, 7, 3};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数据中元素进行排序
     */
    public static void sort(Comparable[] a) {
        //外层循环比较次数
        for (int i = 0; i <a.length-1 ; i++) {
            //比较大小，然后记录元素下标,定义一个变量的下标
            int temp = i;
            for (int j = i+1; j < a.length ; j++) {
                if(greater(a[temp],a[j])){
                    //记录下标
                    temp = j;
                }
            }
            exch(a,i,temp);
        }
    }

    /**
     * 比较大小
     */
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换数组中元素额位置
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
