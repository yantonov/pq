package com.example.pq;

public interface AbstractPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>> {
    boolean insert(QueueItem<ItemKey, ItemPriority> item);

    QueueItem<ItemKey, ItemPriority> top();

    QueueItem<ItemKey, ItemPriority> extract();

    boolean changeKey(QueueItem<ItemKey, ItemPriority> item);

    int size();

    boolean isEmpty();
}
