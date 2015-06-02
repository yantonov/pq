package com.example.pq;

import org.junit.Assert;
import org.junit.Test;

public class BinaryHeapMaxPriorityQueueTest {

    private final MaxPriorityQueue<Integer, Integer> queue = new BinaryHeapMaxPriorityQueue<Integer, Integer>();

    @Test
    public void sizeAfterConstruction() {
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void minimumOnEmptyQueue() {
        Assert.assertNull(queue.maximumKey());
        Assert.assertNull(queue.maximumPriority());
    }

    @Test
    public void insertIncreaseTheSizeOfQueue() {
        queue.insert(1, 1);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void maximumReturnsElementFromQueue() {
        queue.insert(123, 456);
        Integer maximumKey = queue.maximumKey();
        Integer maximumPriority = queue.maximumPriority();
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(123, (int) maximumKey);
        Assert.assertEquals(456, (int) maximumPriority);
    }

    @Test
    public void extractMaximum() {
        queue.insert(123, 456);
        queue.extractMaximum();
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void getMaximumTest() {
        int count = 3;
        for (int i = 1; i <= count; ++i) {
            queue.insert(i, i);
        }
        for (int i = 1, priority = count; i <= count; ++i, --priority) {
            Integer maximumKey = queue.topKey();
            Integer maximumPriority = queue.topPriority();
            queue.extractMaximum();
            Assert.assertEquals(count - i, queue.size());
            Assert.assertEquals(priority, (int) maximumKey);
            Assert.assertEquals(priority, (int) maximumPriority);
        }
    }

    @Test
    public void addRemoveTest() {
        queue.insert(11, 1);
        queue.insert(22, 2);
        queue.insert(33, 3);
        Integer maximumKey = queue.maximumKey();
        Integer maximumPriority = queue.maximumPriority();
        queue.extractMaximum();
        Assert.assertEquals(3, (int) maximumPriority);
        Assert.assertEquals(33, (int) maximumKey);
        queue.insert(44, 4);
        queue.insert(55, 5);
        maximumKey = queue.maximumKey();
        maximumPriority = queue.maximumPriority();
        Assert.assertEquals(5, (int) maximumPriority);
        Assert.assertEquals(55, (int) maximumKey);
    }

    @Test
    public void increaseKeyTest() {
        queue.insert(11, 1);
        queue.insert(22, 2);
        queue.insert(33, 3);
        queue.increaseKey(11, 10);
        Integer maximumKey = queue.maximumKey();
        Integer maximumPriority = queue.maximumPriority();
        queue.extractMaximum();
        Assert.assertEquals(10, (int) maximumPriority);
        Assert.assertEquals(11, (int) maximumKey);
        queue.insert(maximumKey, maximumPriority);
        queue.increaseKey(22, 20);
        maximumKey = queue.maximumKey();
        maximumPriority = queue.maximumPriority();
        Assert.assertEquals(20, (int) maximumPriority);
        Assert.assertEquals(22, (int) maximumKey);
    }

    @Test
    public void increaseKeyForSingleElement() {
        queue.insert(10, 1);
        queue.increaseKey(10, 2);
        Integer maximumKey = queue.maximumKey();
        Integer maximumPriority = queue.maximumPriority();
        Assert.assertEquals(2, (int) maximumPriority);
        Assert.assertEquals(10, (int) maximumKey);
    }

    @Test
    public void notDecreaseKey() {
        queue.insert(10, 1);
        queue.increaseKey(10, 0);
        Integer maximumKey = queue.maximumKey();
        Integer maximumPriority = queue.maximumPriority();
        Assert.assertEquals(1, (int) maximumPriority);
        Assert.assertEquals(10, (int) maximumKey);
    }
}

