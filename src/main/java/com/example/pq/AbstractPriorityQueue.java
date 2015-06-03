package com.example.pq;

// strange interface, not all queue semantics included, thinks about it
public interface AbstractPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>> {

    boolean insert(ItemKey key, ItemPriority priotity);

    int size();

    boolean isEmpty();
}
