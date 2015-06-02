package com.example.pq;

public interface MinPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>> extends AbstractPriorityQueue<ItemKey, ItemPriority> {

    void extractMinimum();

    ItemKey minimumKey();

    ItemPriority minimumPriotity();

    boolean decreaseKey(ItemKey key, ItemPriority value);
}
