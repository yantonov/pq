package com.example.pq;

import java.util.HashMap;
import java.util.Map;

public class HashMapKeyMapper<Key> implements KeyMapper<Key>{

    private Map<Key,Integer> map = new HashMap<Key,Integer>();

    @Override
    public Integer get(Key key) {
        return map.get(key);
    }

    @Override
    public boolean contains(Key key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }

    @Override
    public void put(Key key, Integer value) {
        map.put(key,value);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
