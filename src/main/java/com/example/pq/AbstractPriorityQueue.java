package com.example.pq;

public interface AbstractPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>> {

    boolean insert(ItemKey key, ItemPriority priotity);

    ItemKey topKey();

    ItemPriority topPriority();

    void extract();

    boolean changeKey(ItemKey key, ItemPriority priority);

    int size();

    boolean isEmpty();
}
