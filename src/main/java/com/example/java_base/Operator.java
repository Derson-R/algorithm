package com.example.java_base;

/**
 * 运算符 : Operator
 */
public class Operator {
    public static void main(String[] args) {
        /**
         * 位运算
         */
        int number = 11;
        //相当于除以2
        System.out.println(number >>> 1);
        System.out.println(number >>1);

        // 22 左移一位，相当于乘以2
        System.out.println(number << 1);
    }

    
}
