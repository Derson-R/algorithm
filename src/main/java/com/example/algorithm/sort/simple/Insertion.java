package com.example.algorithm.sort.simple;

import java.util.Arrays;

/**
 * @author desener
 * @date 2021-09-06 14:48
 *
 * 插入排序：1、把所有的元素分为两组，已排序跟未排序
 *          2、找到未排序中的第一个元素，向已排序的组中进行插入；
 *          3、倒序遍历已经排序的元素，依次跟待插入的元素进行比较，直到一个元素小于待插入元素，那么就把这个元素放到这个位置，
 *             其他元素向后移动一位；
 *
 *         （类似于扑克牌码牌的过程）
 *
 *  API： 排序sort(); 比较greater(); 交换 exch();
 **/
public class Insertion {

    public static void main(String[] args) {
        Integer[] a = {8, 4, 2, 6, 1, 7, 3};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }


    /**
     * 对数据中元素进行排序
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length ; i++) {
            for (int j = i; j >0; j--) {
                if(greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }
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
