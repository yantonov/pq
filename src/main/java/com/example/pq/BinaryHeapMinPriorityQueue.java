package com.example.pq;

public class BinaryHeapMinPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>>
        extends AbstractBinaryHeapPriorityQueue<ItemKey, ItemPriority> implements MinPriorityQueue<ItemKey, ItemPriority> {

    public BinaryHeapMinPriorityQueue() {
    }

    public BinaryHeapMinPriorityQueue(KeyMapper<ItemKey> keyMapper) {
        super(keyMapper);
    }

    @Override
    protected boolean isMoreOptimalPriority(Comparable oldPriority, Comparable newPriority) {
        return newPriority.compareTo(oldPriority) < 0;
    }

    @Override
    public ItemKey minimumKey() {
        return this.topKey();
    }

    @Override
    public ItemPriority minimumPriotity() {
        return this.topPriority();
    }

    @Override
    public void extractMinimum() {
        this.extract();
    }

    @Override
    public boolean decreaseKey(ItemKey key, ItemPriority priotity) {
        return this.changeKey(key, priotity);
    }
}
