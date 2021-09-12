package com.example.data_struct.linearlist;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * @author rds
 * @date 2021-09-07 16:59
 *
 * 链表的实现java集合类比较多,java中LinkedList集合也是使用双向链表实现
 **/
public class LinkList {
    public static void main(String[] args) {
        LinkedList<Integer> objects = new LinkedList<>();
        //看linkedList的源码基本上就知道链表的结构
        objects.add(1);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class Node<T> {
        //存储元素
        public T item;
        public Node next;
    }

    //头结点
    private Node head;
    //链表的长度
    private int N;

    //判断是否为空
    private boolean isEmpty(){
        return N==0;
    }

    /**
     * 链表的反转
     */
    public void reverse(){
        //如果是空链表直接返回
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curr){
        if(curr.next == null){
            head.next = curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next = curr;
        //这一步真实作用是为了所有的翻转后最后一个节点指向的null,每次都指向其实是为了最后一次
        curr.next = null;
        return curr;

    }


}

