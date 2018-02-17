package com.botforever;

import com.botforever.ds.MyLinkedList;
import com.botforever.ds.MyNode;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public boolean isUnique(String s) {
        if (s.length() > 128) return false;

        boolean[] chars = new boolean[128];
        int c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (chars[c])
                return false;
            chars[c] = true;
        }
        return true;
    }

    public boolean checkPermutation (String s1, String s2) {
        if (s1 == null || s2 == null) return  false;
        if (s1.length() != s2.length()) return false;
        int[] chars = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)]++;
        }
        int v = 0;
        for (int i = 0; i < s2.length(); i++) {
            v = chars[s2.charAt(i)] - 1;
            if (v < 0) return false;
        }
        return true;
    }

    public String urlify (String s, int len) {
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ')
                p++;
        }
        char[] chars = new char[len + p * 3];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            } else {
                chars[j++] = s.charAt(i);
            }
        }
        return new String(chars);
    }

    public boolean pape (String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return true;
        int[] chars = new int[128];
        char c;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c != ' ') {
                chars[c] = chars[c] + 1;
            }
        }
        int odd = 0;
        for (int i = 0; i < 128; i++) {
            if (chars[i] % 2 != 0) {
                odd++;
                if (odd > 1) return false;
            }
        }
        return true;
    }

    public boolean oneAway(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int l1 = s1.length(), l2 = s2.length();
        if (Math.abs(l1 - l2) > 1) return false;
        boolean diff = false;
        if (l1 == l2) {
            for (int i = 0; i < l1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (diff) {
                        return false;
                    } else {
                        diff = true;
                    }
                }
            }
            return true;
        } else {
            String ls, ss;
            if (l1 > l2) {
                ls = s1;
                ss = s2;
            } else {
                ls = s2;
                ss = s1;
            }
            int j = 0;
            for (int i = 0; i < ls.length(); i++) {
                if (j < ss.length() && ls.charAt(i) != ss.charAt(j)) {
                    if (diff) {
                        return false;
                    } else {
                        diff = true;
                    }
                } else {
                    j++;
                    if (j == ss.length()) {
                        j = ss.length() - 1;
                    }
                }
            }
            return true;
        }
    }

    public String stringCompression(String s) {
        if (s == null) return null;
        int len = s.length();
        if (len < 3) return s;

        int count = 0;
        StringBuilder sb = new StringBuilder();
        char cc = s.charAt(0);
        sb.append(cc);
        count++;

        for (int i = 1; i < len; i++) {
            if (cc == s.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                cc = s.charAt(i);
                count = 1;

                sb.append(cc);

            }
        }
        sb.append(count);
        if (sb.length() < len) return sb.toString();
        else return s;
    }

    public void deleteDups() {
        int[] array = {4,6,7,5,4,5,6,7};
        MyLinkedList mll = new MyLinkedList(array);
        System.out.print("2.1 Before: ");
        mll.print();
        HashSet<Integer> set = new HashSet<Integer>();
        MyNode node = mll.head;
        MyNode prev = null;
        while (node != null) {
            if (set.contains(node.data)) {
                prev.next = node.next;
            } else {
                set.add(node.data);
                prev = node;
            }
            node = node.next;
        }
        System.out.print("2.1 After: ");
        mll.print();
    }

    public void deleteDups2() {
        int[] array = {4,6,7,5,4,5,6,7,3};
        MyLinkedList mll = new MyLinkedList(array);
        System.out.print("2.1 Before: ");
        mll.print();
        MyNode node = mll.head;

        while (node != null) {
            MyNode prev = node;
            MyNode run = node.next;
            while (run != null) {
                if (run.data == node.data) {
                    prev.next = run.next;
                } else {
                    prev = run;
                }
                run = run.next;
            }
            node = node.next;
        }
        System.out.print("2.1 After: ");
        mll.print();
    }

    public void printKthToLast(int k) {
        int[] array = {4,6,7,5,4,5,6,7,3};
        MyLinkedList mll = new MyLinkedList(array);
        System.out.print("2.2 LinkedList: ");
        mll.print();
        if (k >= mll.length()) {
            System.out.format("2.2 k=%d is larger than the list length %d.%n", k, mll.length());
        } else {
            int i = 0;
            MyNode end = mll.head;
            while (i <= k) {
                end = end.next;
                i++;
            }
            MyNode run = mll.head;
            while (end != null) {
                run = run.next;
                end = end.next;
            }
            System.out.format("2.2 k=%dth to last is: %d%n", k, run.data);
        }
    }

    public void partition() {
        int[] array = {3,5,8,5,10,2,1};
        int par = 5;
        MyLinkedList mll = new MyLinkedList(array);
        System.out.print("2.4 LinkedList: ");
        mll.print();
        MyNode run = null;
        MyLinkedList sl = null, ll = null;
        run = mll.head;
        while (run != null) {
            if (run.data < par) {
                if (sl == null) {
                    sl = new MyLinkedList(new MyNode(run.data));
                } else {
                    sl.append(run.data);
                }
            } else {
                if (ll == null) {
                    ll = new MyLinkedList(new MyNode(run.data));
                } else {
                    ll.append(run.data);
                }
            }
            run = run.next;
        }
        if (sl == null) {
            sl = ll;
        } else {
            run = sl.head;
            while (run.next != null) {
                run = run.next;
            }
            run.next = ll.head;
        }
        System.out.print("2.4 Partitioned LinkedList: ");
        sl.print();
    }

    public static void main(String[] args) {
        // write your code here
        Main app = new Main();

        app.partition();
        app.printKthToLast(8);
        app.deleteDups2();
        app.deleteDups();
        System.out.println("1.6 The given string is compressed: " + app.stringCompression("aaa"));
        System.out.println("1.5 The given 2 strings are one away: " + app.oneAway("pale", "bale"));
        System.out.println("1.4 The given string is Palindrome Permutation: " + app.pape("Tact Coa"));
        System.out.println("1.3 URLify the given string: " + app.urlify("Mr John Smith  ", 15));
        System.out.println("1.2 The given 2 strings are permutation: " + app.checkPermutation("abc", "1ba"));
        System.out.println("1.1 The given string is unique: " + app.isUnique(""));
    }
}
