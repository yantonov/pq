package com.example.pq;

public interface MinPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>> extends AbstractPriorityQueue<ItemKey, ItemPriority> {
    QueueItem<ItemKey, ItemPriority> minimum();

    boolean decreaseKey(QueueItem<ItemKey, ItemPriority> item);
}
