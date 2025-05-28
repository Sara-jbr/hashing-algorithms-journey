package org.hashing.algorithms.basic;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static void countFrequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        System.out.println(map);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 1};
        FrequencyCounter.countFrequency(arr); // {1=3, 2=2, 3=1}
    }
}

