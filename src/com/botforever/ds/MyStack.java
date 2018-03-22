package com.botforever.ds;

public class MyStack {
    private MyLinkedListNode top;

    public MyStack(int[] array) {
        MyLinkedListNode node = new MyLinkedListNode(array[0]);
        this.top = node;

        for (int i = 1; i < array.length; i++) {
            this.push(array[i]);
        }
    }

    public MyStack() {
        top = null;
    }

    public MyLinkedListNode pop() {
        if (top == null) return null;
        MyLinkedListNode node = top;
        top = top.next;
        return node;
    }

    public void push(int data) {
        MyLinkedListNode node = new MyLinkedListNode(data);
        node.next = top;
        top = node;
    }

    public MyLinkedListNode peek() {
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void print() {
        MyLinkedListNode node = top;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public int size() {
        int size = 0;
        MyLinkedListNode node = top;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public void sort() {
        if (size() == 1) return;
        MyStack temp = new MyStack();
        if (size() == 2) {
            temp.push(this.pop().data);
            if (this.top.data >= temp.peek().data) {
                this.push(temp.pop().data);
            } else {
                MyLinkedListNode node = this.pop();
                this.push(temp.pop().data);
                this.push(node.data);
            }
            return;
        }
        int first = this.pop().data;
        temp = new MyStack();
        sort();
        MyLinkedListNode peek = top;
        while (peek != null && peek.data < first) {
            temp.push(this.pop().data);
            peek = top;
        }
        this.push(first);
        while (temp.top != null) {
            this.push(temp.pop().data);
        }
    }
}
