package com.botforever;

import java.util.HashMap;

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

    public static void main(String[] args) {
        // write your code here
        Main app = new Main();

        System.out.println("1.1 The given string is unique: " + app.isUnique(""));
        System.out.println("1.2 The given 2 strings are permutation: " + app.checkPermutation("abc", "1ba"));
        System.out.println("1.3 URLify the given string: " + app.urlify("Mr John Smith  ", 15));
    }
}
