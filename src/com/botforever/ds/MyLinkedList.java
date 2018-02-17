package com.botforever.ds;

public class MyLinkedList {
    public MyNode head = null;

    public MyLinkedList(MyNode h) {
        head = h;
    }

    public MyLinkedList(int[] array) {
        MyNode node = new MyNode(array[0]);
        this.head = node;

        for (int i = 1; i < array.length; i++) {
            this.append(array[i]);
        }

    }

    public void append(int d) {
        MyNode end = new MyNode(d);
        MyNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    public void delete(int d) {
        MyNode node = head;
        if (node.data == d) {
            head = head.next;
        }

        while (node.next != null) {
            if (node.next.data == d) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public void print() {
        MyNode node = head;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public int length()  {
        int l = 0;
        MyNode n = head;
        while (n != null) {
            l++;
            n = n.next;
        }
        return  l;
    }
}
