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

    public static void main(String[] args) {
        // write your code here
        Main app = new Main();

        System.out.println("1.1 The given string is unique: " + app.isUnique(""));
        System.out.println("1.2 The given 2 strings are permutation: " + app.checkPermutation("abc", "1ba"));
        System.out.println("1.3 URLify the given string: " + app.urlify("Mr John Smith  ", 15));
        System.out.println("1.4 The given string is Palindrome Permutation: " + app.pape("Tact Coa"));
        System.out.println("1.5 The given 2 strings are one away: " + app.oneAway("pale", "bale"));
    }
}
