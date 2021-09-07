package com.example.algorithm.sort.senior;

import java.util.Arrays;

/**
 * @author desener
 * @date 2021-09-07 9:30
 * <p>
 * 归并排序 ：
 * 1、首先了解的是一种递归算法；
 * 2、尽可能的一组数据拆分成两个元素相等的子组(奇数存在不等的数组)，并对每一个子组继续拆分，知道拆分后的子组的元素个数是1为止；
 * 3、将相邻的两个自组合并成一个有序的大组；（归并）
 * 4、不断重复步骤2（不停的归并），知道最终只有一个组为止，即有序数组；
 * <p>
 * API：
 * sort(Compare[] a)排序；
 * sort(Compare[] a,int i,intj)组a中索引i到索引j中间的数据进行排序；
 * merge(Compare[] a,int i,int mid,intj) 从索引i到mid为一个子组，索引mid+1到索引j为另一个子组，两个子组合并为一个大的有序数组；
 * less()比较大小；
 * exch()交换数组中两个索引处的值
 * <p>
 * 成员变量：Comparable[] assist ,完成归并操作需要的辅助数组
 *
 * 复杂度： O(n*logN);
 * 缺点： 需要申请额外的数组空间，典型的已空间换时间
 **/
public class Merge {

    public static void main(String[] args) {
        Integer[] a = {8, 4, 2, 6, 1, 7, 3};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static Comparable[] assist;

    //一个阶乘的递归方法实现
    public static long jiecheng(int n) {
        //这个就是终止条件
        if (n == 1) {
            return 1;
        }
        return n * jiecheng(n - 1);
    }

    //比较
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //交换数据
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //排序
    public static void sort(Comparable[] a) {
        //初始化辅助数组/
        assist = new Comparable[a.length];
        //定义一个i跟j变量，分别记录数组中的最小跟最大索引
        int i = 0;
        int j = a.length - 1;
        //调用sort的重载方法完成数组a中i到j的元素的排序
        sort(a, i, j);
    }

    //部分排序
    private static void sort(Comparable[] a, int i, int j) {
        //做安全性校验
        if (j <= i) {
            return;
        }
        //对i,j间的数据进行分组
        int mid = i + (j - i) / 2;
        //分别对每一个数组进行排序
        sort(a, i, mid);
        sort(a, mid + 1, j);
        //然后归并
        merge(a, i, mid, j);
    }

    //核心逻辑，归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //需要定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        //遍历，移动p1、p2指针，比较索引处的值，小的放在辅助数据对应的指针的值
        while (p1 <= mid && p2 <= hi) {
            //比较对应处的索引值
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }
        //下面p1跟p2只有一个没有走完
        //遍历，如果p1没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组中
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        //遍历，如果p2没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组中
        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }
        //把辅助数据拷贝到原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }
}
