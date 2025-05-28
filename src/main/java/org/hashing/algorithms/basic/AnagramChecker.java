package org.hashing.algorithms.basic;

public class AnagramChecker {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;
        for (int i : count) if (i != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Are anagrams? " + AnagramChecker.isAnagram("listen", "silent")); // true
        System.out.println("Are anagrams? " + AnagramChecker.isAnagram("hello", "world"));   // false
    }
}

