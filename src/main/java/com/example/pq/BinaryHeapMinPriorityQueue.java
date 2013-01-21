package com.example.pq;

import java.util.Map;

public class BinaryHeapMinPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>>
        extends BinaryHeapPriorityQueue<ItemKey, ItemPriority> implements MinPriorityQueue<ItemKey, ItemPriority> {

    public BinaryHeapMinPriorityQueue() {
    }

    public BinaryHeapMinPriorityQueue(Map<ItemKey, Integer> keyMapper) {
        super(keyMapper);
    }

    @Override
    protected boolean isMoreOptimalPriority(Comparable oldPriority, Comparable newPriority) {
        return newPriority.compareTo(oldPriority) < 0;
    }

    @Override
    public QueueItem<ItemKey, ItemPriority> minimum() {
        return this.top();
    }

    @Override
    public boolean decreaseKey(QueueItem<ItemKey, ItemPriority> item) {
        return this.changeKey(item);
    }
}
