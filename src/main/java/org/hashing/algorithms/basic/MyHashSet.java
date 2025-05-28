package org.hashing.algorithms.basic;

class MyHashSet<E> {
    private MyHashMap<E, Object> map = new MyHashMap<>();
    private static final Object DUMMY = new Object();

    public void add(E value) {
        map.put(value, DUMMY);
    }

    public boolean contains(E value) {
        return map.get(value) != null;
    }
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("banana");

        System.out.println("Contains banana? " + set.contains("banana")); // true
        System.out.println("Contains mango? " + set.contains("mango"));   // false
    }
}
