package com.example.pq;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryHeapPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>>
        implements AbstractPriorityQueue<ItemKey, ItemPriority> {

    private List<ItemKey> queueKey;
    private List<ItemPriority> queuePriority;
    private KeyMapper<ItemKey> keyMapper;
    private int queueSize;

    public BinaryHeapPriorityQueue() {
        initQueue();
        this.keyMapper = new HashMapKeyMapper<ItemKey>();
    }

    private void initQueue() {
        queueSize = 0;
        this.queueKey = new ArrayList<ItemKey>();
        this.queueKey.add(null);
        this.queuePriority = new ArrayList<ItemPriority>();
        this.queuePriority.add(null);
    }

    public BinaryHeapPriorityQueue(KeyMapper<ItemKey> keyMapper) {
        this();
        this.keyMapper = keyMapper;
    }

    @Override
    public boolean insert(ItemKey key, ItemPriority priority) {
        if (keyMapper.contains(key))
            return false;
        queueKey.add(key);
        queuePriority.add(priority);
        ++queueSize;
        keyMapper.put(key, queueSize);
        moveUp(queueSize);
        return true;
    }

    private void moveUp(int startIndex) {
        ItemPriority itemPriority = queuePriority.get(startIndex);
        for (int index = startIndex; index > 1; index >>= 1) {
            int parentIndex = index >> 1;
            ItemPriority parentPriority = queuePriority.get(parentIndex);
            if (isMoreOptimalPriority(parentPriority, itemPriority)) {
                swap(parentIndex, index);
            } else {
                break;
            }
        }
    }

    @Override
    public ItemKey topKey() {
        if (queueSize == 0) {
            return null;
        }
       return queueKey.get(1);
    }

    @Override
    public ItemPriority topPriority() {
        if (queueSize == 0) {
            return null;
        }
        return queuePriority.get(1);
    }

    @Override
    public void extract() {
        ItemKey key = queueKey.get(1);
        keyMapper.remove(key);
        if (queueSize > 1) {
            queueKey.set(1, queueKey.get(queueSize));
            queuePriority.set(1, queuePriority.get(queueSize));
            keyMapper.put(queueKey.get(1), 1);
        }
        queueKey.remove(queueSize);
        queuePriority.remove(queueSize);
        --queueSize;
        heapify(1);
    }

    private void heapify(int startIndex) {
        int left, right, max;
        int size = queueSize;
        while (true) {
            left = startIndex << 1;
            right = left + 1;
            if ((left <= size) && (isMoreOptimalPriority(queuePriority.get(startIndex), queuePriority.get(left)))) {
                max = left;
            } else {
                max = startIndex;
            }
            if ((right <= size) && (isMoreOptimalPriority(queuePriority.get(max), queuePriority.get(right)))) {
                max = right;
            }
            if (max != startIndex) {
                swap(max, startIndex);
                startIndex = max;
            } else {
                break;
            }
        }
    }

    @Override
    public boolean changeKey(ItemKey key, ItemPriority priotity) {
        if (!keyMapper.contains(key)) {
            return false;
        }
        int index = keyMapper.get(key);
        if (!isMoreOptimalPriority(queuePriority.get(index), priotity)) {
            return false;
        }
        queueKey.set(index, key);
        queuePriority.set(index, priotity);
        moveUp(index);
        return true;
    }

    protected abstract boolean isMoreOptimalPriority(ItemPriority oldPriority, ItemPriority newPriority);

    private void swap(int firstIndex, int secondIndex) {
        ItemKey firstKey = queueKey.get(firstIndex);
        ItemKey secondKey = queueKey.get(secondIndex);
        ItemPriority firstPriority = queuePriority.get(firstIndex);
        ItemPriority secondPriority = queuePriority.get(secondIndex);


        keyMapper.put(firstKey, secondIndex);
        keyMapper.put(secondKey, firstIndex);
        queueKey.set(firstIndex, secondKey);
        queueKey.set(secondIndex, firstKey);
        queuePriority.set(firstIndex, secondPriority);
        queuePriority.set(secondIndex, firstPriority);
    }

    @Override
    public int size() {
        return this.queueSize;
    }

    @Override
    public boolean isEmpty() {
        return this.queueSize == 0;
    }
}
