package org.hashing.algorithms.intermediate;

import java.util.*;

public class intermediateHashingAlgorithms {

    // 🔹 Two Sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // 🔹 Subarray with 0 sum
    public static boolean subarrayWithZeroSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(sum) || sum == 0) return true;
            set.add(sum);
        }
        return false;
    }

    // 🔹 Subarray with sum = K
    public static int subarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 🔹 Longest consecutive subsequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int streak = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }

    // 🔹 Isomorphic strings
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if ((mapST.containsKey(c1) && mapST.get(c1) != c2) ||
                    (mapTS.containsKey(c2) && mapTS.get(c2) != c1)) return false;
            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }
        return true;
    }

    // 🔹 Word pattern matching
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if ((map1.containsKey(c) && !map1.get(c).equals(w)) ||
                    (map2.containsKey(w) && map2.get(w) != c)) return false;
            map1.put(c, w);
            map2.put(w, c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Two Sum: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Subarray with 0 Sum: " + subarrayWithZeroSum(new int[]{4, 2, -3, 1, 6}));
        System.out.println("Subarray Sum = K: " + subarraySumEqualsK(new int[]{1, 1, 1}, 2));
        System.out.println("Longest Consecutive: " + longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("Isomorphic Strings: " + isIsomorphic("egg", "add"));
        System.out.println("Word Pattern: " + wordPattern("abba", "dog cat cat dog"));
    }

}
