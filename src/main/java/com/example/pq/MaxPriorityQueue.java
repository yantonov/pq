package com.example.pq;

public interface MaxPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>>
        extends AbstractPriorityQueue<ItemKey, ItemPriority> {
    QueueItem<ItemKey, ItemPriority> maximum();

    boolean increaseKey(QueueItem<ItemKey, ItemPriority> item);
}
