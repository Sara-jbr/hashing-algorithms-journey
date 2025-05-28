package org.hashing.algorithms.basic;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> group(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Grouped Anagrams: " + GroupAnagrams.group(words));
        // Example Output: [[eat, tea, ate], [tan, nat], [bat]]
    }
}

