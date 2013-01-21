package com.example.pq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BinaryHeapPriorityQueue<ItemKey, ItemPriority extends Comparable<ItemPriority>>
        implements AbstractPriorityQueue<ItemKey, ItemPriority> {

    private List<QueueItem<ItemKey, ItemPriority>> queue;
    private Map<ItemKey, Integer> keyMapper;
    private int queueSize;

    public BinaryHeapPriorityQueue() {
        initQueue();
        this.keyMapper = new HashMap<ItemKey, Integer>();
    }

    private void initQueue() {
        queueSize = 0;
        this.queue = new ArrayList<QueueItem<ItemKey, ItemPriority>>();
        this.queue.add(null);
    }

    public BinaryHeapPriorityQueue(Map<ItemKey, Integer> keyMapper) {
        this();
        this.keyMapper = keyMapper;
    }

    @Override
    public boolean insert(QueueItem<ItemKey, ItemPriority> item) {
        if (keyMapper.containsKey(item.getKey()))
            return false;
        queue.add(item);
        ++queueSize;
        keyMapper.put(item.getKey(), queueSize);
        moveUp(queueSize);
        return true;
    }

    private void moveUp(int startIndex) {
        ItemPriority itemPriority = queue.get(startIndex).getPriority();
        for (int index = startIndex; index > 1; index >>= 1) {
            int parentIndex = index >> 1;
            QueueItem<ItemKey, ItemPriority> parentItem = queue.get(parentIndex);
            if (isMoreOptimalPriority(parentItem.getPriority(), itemPriority)) {
                swap(parentIndex, index);
            } else {
                break;
            }
        }
    }

    @Override
    public QueueItem<ItemKey, ItemPriority> top() {
        if (queueSize == 0) {
            return null;
        }
        QueueItem<ItemKey, ItemPriority> max = queue.get(1);
        keyMapper.remove(max.getKey());
        if (queueSize > 1) {
            queue.set(1, queue.get(queueSize));
            keyMapper.put(queue.get(1).getKey(), 1);
        }
        queue.remove(queueSize);
        --queueSize;
        heapify(1);
        return max;
    }

    private void heapify(int startIndex) {
        int left, right, max;
        int size = queueSize;
        while (true) {
            left = startIndex << 1;
            right = left + 1;
            if ((left <= size) && (isMoreOptimalPriority(queue.get(startIndex).getPriority(), queue.get(left).getPriority()))) {
                max = left;
            } else {
                max = startIndex;
            }
            if ((right <= size) && (isMoreOptimalPriority(queue.get(max).getPriority(), queue.get(right).getPriority()))) {
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
    public boolean changeKey(QueueItem<ItemKey, ItemPriority> item) {
        if (!keyMapper.containsKey(item.getKey())) {
            return false;
        }
        int index = keyMapper.get(item.getKey());
        if (!isMoreOptimalPriority(queue.get(index).getPriority(), item.getPriority())) {
            return false;
        }
        queue.set(index, item);
        moveUp(index);
        return true;
    }

    protected abstract boolean isMoreOptimalPriority(ItemPriority oldPriority, ItemPriority newPriority);

    private void swap(int firstIndex, int secondIndex) {
        QueueItem<ItemKey, ItemPriority> first = queue.get(firstIndex);
        QueueItem<ItemKey, ItemPriority> second = queue.get(secondIndex);

        keyMapper.put(first.getKey(), secondIndex);
        keyMapper.put(second.getKey(), firstIndex);
        queue.set(firstIndex, second);
        queue.set(secondIndex, first);
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
