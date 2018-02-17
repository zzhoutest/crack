package com.botforever.ds;

public class MyStack {
    private MyNode top;

    public MyNode pop() {
        if (top == null) return null;
        MyNode node = top;
        top = top.next;
        return node;
    }

    public void push(int data) {
        MyNode node = new MyNode(data);
        node.next = top;
        top = node;
    }

    public MyNode peek() {
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
