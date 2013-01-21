package com.example.pq;

public interface KeyMapper<Key, Integer> {
    Integer get(Key key);

    boolean contains(Key key);

    void remove(Key key);

    void put(Key key, Integer value);
}
