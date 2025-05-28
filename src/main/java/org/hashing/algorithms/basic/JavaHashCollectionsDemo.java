package org.hashing.algorithms.basic;

import java.util.*;

public class JavaHashCollectionsDemo {

    enum Day { MON, TUE, WED }

    public static void main(String[] args) {

        // HashMap: Unordered key-value pairs
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Sara", 1);
        hashMap.put("John", 2);
        System.out.println("HashMap (unordered): " + hashMap);

        // HashSet: Unordered unique elements
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("World");
        System.out.println("HashSet (unordered): " + hashSet);

        // LinkedHashMap: Maintains insertion order
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Two", 2);
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        // TreeMap: Sorted by keys
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Charlie", 3);
        treeMap.put("Alice", 1);
        treeMap.put("Bob", 2);
        System.out.println("TreeMap (sorted by key): " + treeMap);

        // Hashtable: Thread-safe version of HashMap (legacy)
        Map<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("Key1", 100);
        hashtable.put("Key2", 200);
        System.out.println("Hashtable: " + hashtable);

        // EnumMap: Keys must be enum types, very fast
        EnumMap<Day, String> enumMap = new EnumMap<>(Day.class);
        enumMap.put(Day.MON, "Work");
        enumMap.put(Day.TUE, "Study");
        enumMap.put(Day.WED, "Rest");
        System.out.println("EnumMap: " + enumMap);
    }
}

