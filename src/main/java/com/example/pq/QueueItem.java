package com.example.pq;

public interface QueueItem<Key, Priority> {
    Priority getPriority();

    Key getKey();
}
