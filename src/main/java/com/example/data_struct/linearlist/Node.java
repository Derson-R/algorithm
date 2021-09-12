/*
package com.example.data_struct.linearlist;

import lombok.AllArgsConstructor;

*/
/**
 * @author rds
 * @date 2021-09-07 16:49
 *
 * 链表的API设计：1、构造方法  2、成员变量 T,存储的数据结构类型
 * 单项链表跟双向链表的构造区别在于：是否每个元素都有前驱
 **//*

@AllArgsConstructor
public class Node<T> {
    //存储元素
    public T item;
    public Node next;

    //双向链表多一个节点
    //public Node pre; //指向上一个节点

    public static void main(String[] args) {
        //生成链表:1、先创建节点 2、链接节点
        Node<Integer> one = new Node<Integer>(12,null);
        Node<Integer> two = new Node<Integer>(34,null);
        Node<Integer> three = new Node<Integer>(145,null);
        Node<Integer> four = new Node<Integer>(99,null);

        one.next = two;
        two.next = three;
        three.next = four;
    }

}
*/
