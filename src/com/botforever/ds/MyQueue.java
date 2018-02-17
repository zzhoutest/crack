package com.botforever.ds;

public class MyQueue {
    private MyNode first, last;

    public void add(int data) {
        MyNode node = new MyNode(data);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public MyNode remove() {
        if (first == null) return first;
        MyNode node = first;
        first = first.next;
        if (first == null) last = null;
        return node;
    }

    public  MyNode peek() {
        return first;
    }

    public boolean isEmpty() {
        return  first == null;
    }
}
