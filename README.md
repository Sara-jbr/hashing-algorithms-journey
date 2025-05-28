#  Java Hash Collections Practice

Welcome to my **Java Hash Collections Practice** project!

In this mini-project, I dive into the **core concepts of hashing** and demonstrate how Java’s built-in **hash-based collections** can be used to solve real-world programming problems efficiently.

Hashing is a foundational concept in computer science. It allows us to **store and access data in constant average time (O(1))**, making it a key technique in building fast and scalable software.

---

##  Introduction: What is Hashing?

**Hashing** is a method of converting data (typically keys like strings, numbers, etc.) into a fixed-size numerical value called a **hash code**, which is then used to store and retrieve data efficiently in a data structure like a hash table.

Think of hashing like assigning a **unique address** to every piece of data — so you can jump directly to it without searching linearly.

For example:
```java
"apple" → 9301
"banana" → 5674
```

A good **hash function** ensures that these hash codes are:

-  **Uniformly distributed** – to avoid clustering and ensure even spread of keys
-  **Consistent** – the same input should always generate the same hash code
-  **Fast to compute** – for quick insertions, lookups, and deletions

---

However, **two different keys** might sometimes produce the **same hash code** — this is known as a **collision**.

To handle collisions, hash-based data structures use strategies such as:

-  **Chaining** – store multiple values at the same index using a linked list or another collection
-  **Probing** – search for the next available slot using techniques like linear or quadratic probing

---

##  Why Learn Hashing?

Hashing enables:

-  Fast lookup, insertion, deletion (O(1) average time)
-  Efficient data organization
-  Solving real-world problems like frequency counting, duplicate detection, and caching

> **Mastering hashing = mastering fast data access!**

---

##  Where Are Hash-Based Collections Used?

| Real-World Scenario            | How Hashing Helps                                        |
|-------------------------------|-----------------------------------------------------------|
| Caching (e.g., LRU, Redis)     | Store and retrieve frequently used data quickly          |
| Databases                      | Indexing rows for quick searches                         |
| Compilers / Interpreters       | Symbol table for variable/function lookup                |
| Web Browsers / Servers         | Storing headers, cookies, sessions efficiently           |
| Algorithms (e.g., Two Sum)     | Track past elements with constant-time lookup            |
| Blockchain / Cryptography      | Ensure data integrity via hash functions                 |

---

##  Java Hash-Based Collections in This Project

| Collection                     | Description                                                             |
|--------------------------------|-------------------------------------------------------------------------|
| `HashMap<K, V>`                | Unordered key-value pairs, allows `null` key and multiple `null` values |
| `HashSet<E>`                   | Unordered collection of unique elements                                 |
| `LinkedHashMap<K, V>`          | Maintains insertion order, useful for LRU caching                       |
| `TreeMap<K, V>`                | Sorted map based on keys (uses Red-Black tree)                          |
| `Hashtable<K, V>`              | Legacy, synchronized version of HashMap                                 |
| `EnumMap<K extends Enum<K>, V>`| Specialized Map for enum keys — very efficient                           |

---

