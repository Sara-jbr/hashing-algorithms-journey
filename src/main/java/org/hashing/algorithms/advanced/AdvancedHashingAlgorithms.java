package org.hashing.algorithms.advanced;

import java.util.*;

public class AdvancedHashingAlgorithms {

    // 🔹 Group Anagrams using Sorted String
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // 🔹 Custom hash key object
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // 🔹 Minimum Window Substring
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, count = t.length(), minLen = Integer.MAX_VALUE, minStart = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    // 🔹 Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    // 🔹 Trie + Hash: Autocomplete / Word Dictionary
    static class Trie {
        static class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isEnd;
        }

        Node root = new Node();

        void insert(String word) {
            Node node = root;
            for (char c : word.toCharArray())
                node = node.children.computeIfAbsent(c, k -> new Node());
            node.isEnd = true;
        }

        boolean search(String word) {
            Node node = root;
            for (char c : word.toCharArray()) {
                node = node.children.get(c);
                if (node == null) return false;
            }
            return node.isEnd;
        }

        boolean startsWith(String prefix) {
            Node node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) return false;
            }
            return true;
        }
    }

    // 🔹 Rabin-Karp Algorithm
    public static int rabinKarp(String text, String pattern) {
        int pLen = pattern.length();
        int tLen = text.length();
        if (pLen > tLen) return -1;

        int base = 256, mod = 101;
        int h = 1, pHash = 0, tHash = 0;

        for (int i = 0; i < pLen - 1; i++) h = (h * base) % mod;
        for (int i = 0; i < pLen; i++) {
            pHash = (base * pHash + pattern.charAt(i)) % mod;
            tHash = (base * tHash + text.charAt(i)) % mod;
        }

        for (int i = 0; i <= tLen - pLen; i++) {
            if (pHash == tHash && text.substring(i, i + pLen).equals(pattern)) return i;
            if (i < tLen - pLen) {
                tHash = (base * (tHash - text.charAt(i) * h) + text.charAt(i + pLen)) % mod;
                if (tHash < 0) tHash += mod;
            }
        }
        return -1;
    }

    // 🔹 LRU Cache
    static class LRUCache {
        class Node {
            int key, value;
            Node prev, next;

            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> cache;
        private final Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) remove(cache.get(key));
            if (cache.size() == capacity) remove(tail.prev);
            insert(new Node(key, value));
        }

        private void insert(Node node) {
            cache.put(node.key, node);
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            node.next = headNext;
            headNext.prev = node;
        }

        private void remove(Node node) {
            cache.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    // MAIN method for testing
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        Set<Point> set = new HashSet<>();
        set.add(new Point(1, 2));
        System.out.println(set.contains(new Point(1, 2))); // true

        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC

        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.startsWith("app")); // true

        System.out.println(rabinKarp("hello world", "world")); // 6

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1
    }
}
