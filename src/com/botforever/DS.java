package com.botforever;

public class DS {
    class MyNode {
        public MyNode next = null;
        public int data;

        public  MyNode(int d) {
            data = d;
        }
    }

    class MyLinkedList {
        public MyNode head = null;

        public MyLinkedList(MyNode h) {
            head = h;
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


    }
}
