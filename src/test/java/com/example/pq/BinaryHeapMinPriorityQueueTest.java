package com.example.pq;

import junit.framework.Assert;
import org.junit.Test;

public class BinaryHeapMinPriorityQueueTest {

    private final MinPriorityQueue<Integer, Integer> queue = new BinaryHeapMinPriorityQueue<Integer, Integer>();

    @Test
    public void sizeAfterConstruction() {
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void minimumOnEmptyQueue() {

        Assert.assertNull(queue.minimumKey());
        Assert.assertNull(queue.minimumPriotity());
    }

    @Test
    public void insertIncreaseTheSizeOfQueue() {
        queue.insert(1, 1);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void minimumReturnsElementFromQueue() {
        queue.insert(123, 456);
        Integer minimumKey = queue.minimumKey();
        Integer minimumPriority = queue.minimumPriotity();
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(123, (int) minimumKey);
        Assert.assertEquals(456, (int) minimumPriority);
    }

    @Test
    public void extractMaximum() {
        queue.insert(123, 456);
        queue.extractMinimum();
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void getMinimumTest() {
        int count = 3;
        for (int i = 1; i <= count; ++i) {
            queue.insert(i, i);
        }
        for (int i = 1, priority = 1; i <= count; ++i, ++priority) {
            Integer maximumKey = queue.minimumKey();
            Integer maximumPriority = queue.minimumPriotity();
            queue.extractMinimum();
            Assert.assertEquals(count - i, queue.size());
            Assert.assertEquals(priority, (int) maximumPriority);
            Assert.assertEquals(priority, (int) maximumKey);
        }
    }

    @Test
    public void addRemoveTest() {
        queue.insert(11, 1);
        queue.insert(22, 2);
        queue.insert(33, 3);
        Integer key = queue.minimumKey();
        Integer priority = queue.minimumPriotity();
        queue.extractMinimum();
        Assert.assertEquals(1, (int) priority);
        Assert.assertEquals(11, (int) key);
        queue.insert(44, 4);
        queue.insert(55, 5);
        key = queue.minimumKey();
        priority = queue.minimumPriotity();
        Assert.assertEquals(2, (int) priority);
        Assert.assertEquals(22, (int) key);
    }

    @Test
    public void decreaseKeyForMultipleElements() {
        queue.insert(11, 1);
        queue.insert(22, 2);
        queue.insert(33, 3);
        queue.decreaseKey(11, -1);
        Integer minKey = queue.minimumKey();
        Integer minPriority = queue.minimumPriotity();
        queue.extractMinimum();
        Assert.assertEquals(-1, (int)minPriority);
        Assert.assertEquals(11, (int)minKey);
        queue.insert(minKey,minPriority);
        queue.decreaseKey(22, -2);
        minKey = queue.minimumKey();
        minPriority = queue.minimumPriotity();
        Assert.assertEquals(-2, (int) minPriority);
        Assert.assertEquals(22, (int) minKey);
    }

    @Test
    public void decreaseKeyForSingleElement() {
        queue.insert(10, 1);
        queue.decreaseKey(10, 0);
        Integer minKey = queue.minimumKey();
        Integer minPriority = queue.minimumPriotity();
        Assert.assertEquals(0, (int) minPriority);
        Assert.assertEquals(10, (int) minKey);
    }

    @Test
    public void notIncreaseKey() {
        queue.insert(10, 1);
        queue.decreaseKey(10, 2);
        Integer minKey = queue.minimumKey();
        Integer minPriority = queue.minimumPriotity();
        Assert.assertEquals(1, (int) minPriority);
        Assert.assertEquals(10, (int) minKey);
    }
}

