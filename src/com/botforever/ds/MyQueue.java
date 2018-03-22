package com.botforever.ds;

public class MyQueue {
    private MyLinkedListNode first, last;

    public void add(int data) {
        MyLinkedListNode node = new MyLinkedListNode(data);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public MyLinkedListNode remove() {
        if (first == null) return first;
        MyLinkedListNode node = first;
        first = first.next;
        if (first == null) last = null;
        return node;
    }

    public MyLinkedListNode peek() {
        return first;
    }

    public boolean isEmpty() {
        return  first == null;
    }
}
