package org.hashing.algorithms.basic;

import java.util.LinkedList;
import java.util.List;

class MyHashMap<K, V> {
    private static final int SIZE = 16;
    private List<Entry<K, V>>[] table;

    public MyHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) table[i] = new LinkedList<>();
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry(K k, V v) { key = k; value = v; }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Sara", 25);
        map.put("John", 30);

        System.out.println("Sara's age: " + map.get("Sara"));
        System.out.println("Unknown: " + map.get("Ali")); // null
    }
}
