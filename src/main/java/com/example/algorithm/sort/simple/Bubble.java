package com.example.algorithm.sort.simple;

import java.util.Arrays;

/**
 * @author desener
 * @date 2021-09-06 13:36
 * <p>
 * 冒泡排序：1、比较相邻的元素。如果前一个元素比后一个元素大，就交换这两个元素的位置
 * 2、对每一对相邻的元素做同样的工作，从开始第一对元素到结尾最后一对元素，最终最后位置的元素就是最大值。到此，第一次冒泡结束
 * <p>
 * <p>
 * API设计：1、构造方法：创建一个冒泡对象
 * 2、成员方法：sort()对象排序方法；greater()比较大小方法；exch()交换位置方法；
 * <p>
 * 性能：时间复杂度0（n^2）
 **/
public class Bubble {

    public static void main(String[] args) {

        Integer[] a = {8, 4, 2, 6, 1, 7, 3};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对数据中元素进行排序
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
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
