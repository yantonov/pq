package com.example.pq;

class QueueTestItem implements QueueItem<Integer, Integer> {
    private int priority;
    private int key;

    public QueueTestItem(int key, int priority) {
        this.priority = priority;
        this.key = key;
    }

    @Override
    public Integer getPriority() {
        return priority;
    }

    @Override
    public Integer getKey() {
        return key;
    }
}
