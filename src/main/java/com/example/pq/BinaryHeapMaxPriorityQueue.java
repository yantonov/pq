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
    public ItemKey maximumKey() {
        return this.topKey();
    }

    @Override
    public ItemPriority maximumPriority() {
        return this.topPriority();
    }

    @Override
    public void extractMaximum() {
        this.extract();
    }

    @Override
    public boolean increaseKey(ItemKey key, ItemPriority priority) {
        return this.changeKey(key, priority);
    }
}
