package com.example.algorithm.sort.senior;

import java.util.Arrays;

/**
 * @author desener
 * @date 2021-09-07 13:29
 * <p>
 * 快速排序：
 * 1、首先定义一个分界值，通过分界值将数组分成左右两个部分；
 * 2、将大于或等于分界值的放到右边，小于或等于的放到左边；
 * 3、然后左边跟右边数据在重复第二步，继续拆分；
 * 4、重复上叙过程，通过递归将两边都排序好了，最后整个数据数组也排序好了
 * <p>
 * API:
 * sort(Compare[] a)排序；
 * sort(Compare[] a,int i,intj)组a中索引i到索引j中间的数据进行排序；
 * partition(Compare[] a,int i,intj) 在数据a中，从索引i 到索引 j之间的元素进行分组，并返回分组界限对应的索引；
 * less()比较大小；
 * exch()交换数组中两个索引处的值
 * <p>
 * <p>
 * 切分原理 ：
 * 1、找一个基准值，用两个指针分别指向数组的头部和尾部；
 * 2、先从尾部开始搜索一个比基准值小的元素，搜索到即停止，并记录指针的位置；
 * 3、再从头部开始搜索一个比基准值大的元素，搜索到即停止，并记录指针的位置；
 * 4、交换左右两个记录指针位置的值；
 * 5、重复2/3/4步骤，直到右边的指针大于左边的指针，结束
 **/
public class Quick {
    public static void main(String[] args) {
        //Integer[] a = {8, 4, 2, 6, 1, 7, 3};
        Integer[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
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
        //对i,j间的数据进行分组(左子组跟右子组)
        int partion = partion(a, i, j); //返回的是分界值变换后所在的索引
        //分别对每一个数组进行排序
        sort(a, i, partion - 1);
        sort(a, partion + 1, j);
    }

    //核心逻辑，切分
    private static int partion(Comparable[] a, int lo, int hi) {
        //确定分界值
        Comparable key = a[0];
        //定义两个索引，分别指向待切分元素的最小索引跟最大索引的下一位处
        int left = lo;
        int right = hi + 1;
        //切分
        while (true) {
            //先从右往左扫描，找到一个比分界值小的值停止
            while (less(key, a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            //先从左往右扫描，找到一个比分界值大的值停止
            while (less(a[++left], key)) {
                if (left == hi) {
                    break;
                }
            }
            //判断 left>=right 接续循环，则证明元素扫描完毕，结束循环；如果不是，则交换元素即可
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }
        //交换分界值所在的位置
        exch(a, lo, right);

        return right;
    }
}
