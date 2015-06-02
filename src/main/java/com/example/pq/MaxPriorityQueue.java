package com.example.pq;

public interface MaxPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>>
        extends AbstractPriorityQueue<ItemKey, ItemPriority> {
    void extractMaximum();

    ItemKey maximumKey();

    ItemPriority maximumPriority();

    boolean increaseKey(ItemKey key, ItemPriority priotity);
}
