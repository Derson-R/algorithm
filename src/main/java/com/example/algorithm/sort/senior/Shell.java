package com.example.algorithm.sort.senior;

/**
 * @author desener
 * @date 2021-09-06 15:56
 * <p>
 * 希尔排序：
 * 1、选定一个增长量h,按照增长量h作为分组依据，对数据进行分组；
 * 2、对分组好的每一组元素进行插入排序；
 * 3、减小增长量，最小减为1，重复第二步操作；
 * <p>
 * 本质：分组 + 插入
 * <p>
 * <p>
 * API设计：
 * 1、构造方法
 * 2、成员方法：sort()对象排序方法；greater()比较大小方法；exch()交换位置方法；
 **/
public class Shell {

    /**
     * 对数据中元素进行排序
     */
    public static void sort(Comparable[] a) {
        //1、根据数据a的长度，确定增长量h的值
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        //2、希尔排序
        //while进行分组
        while (h >= 1) {
            //2.1、找到待插入的元素
            for (int i = h; i < a.length; i++) {
                //2.2、把待插入元素插入到有序数列中
                for (int j = i; j >= h; j -= h) {
                    //待插入元素a[j],比较a[j]和a[j-h]
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            //减小h的值
            h = h / 2;
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
