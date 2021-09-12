package com.example.data_struct.linearlist;

/**
 * @author rds
 * @date 2021-09-08 19:37
 *
 * 栈：FILO，先进后出的特殊线性表； 压栈：插入数据；   弹栈：删除数据；   类似于子弹夹：栈顶，栈底
 *
 * 栈：可以使用数组也可以使用链表的数据结构实现栈
 **/
public class Stack<T> {
    private Node head;//记录首节点

    private int N;//节点个数

    private class Node<T> {
        //存储元素
        public T item;
        public Node next;

        public Node (T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //构造函数初始化
    public Stack(){
        this.head = new Node(null,null);
        this.N = 0 ;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N== 0;
    }

    //获取栈中元素
    public int size(){
        return N;
    }

    //压栈
    public void push (T t){
        //先找到首节点指向的第一个节点
        Node next = head.next;
        //创建新的节点
        Node newnNode = new Node(t, null);
        //让首节点指向新的节点

        //让首节点指向原来的第一个节点

        //size +1


    }

    //弹栈
    public void pop(){
        //自己实现
    }


    /**
     * 案例
     * 1、左右括号匹配原则
     * 2、逆波兰表达式求职问题
     */








}
