package com.example.data_struct.linearlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 队列
 * FIFO 先进先出
 */
public class Queue {
    public static void main(String[] args) {
        BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        /**
         * put的操作
         */
        //arrayBlockingQueue.put("1");

    }


    private Node head;//记录首节点
    private Node last;//记录尾节点
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
}
