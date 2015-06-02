package com.example.pq;

public class BinaryHeapMaxPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>>
        extends BinaryHeapPriorityQueue<ItemKey, ItemPriority>
        implements MaxPriorityQueue<ItemKey, ItemPriority> {

    public BinaryHeapMaxPriorityQueue() {
    }

    public BinaryHeapMaxPriorityQueue(KeyMapper<ItemKey> keyMapper) {
        super(keyMapper);
    }

    @Override
    protected boolean isMoreOptimalPriority(Comparable oldPriority, Comparable newPriority) {
        return newPriority.compareTo(oldPriority) > 0;
    }

    @Override
    public QueueItem<ItemKey, ItemPriority> maximum() {
        return this.top();
    }

    @Override
    public QueueItem<ItemKey, ItemPriority> extractMaximum() {
        return this.extract();
    }

    @Override
    public boolean increaseKey(QueueItem<ItemKey, ItemPriority> item) {
        return this.changeKey(item);
    }
}
