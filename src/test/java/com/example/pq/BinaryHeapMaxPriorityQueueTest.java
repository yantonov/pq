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
        junit.framework.Assert.assertNull(queue.maximum());
    }

    @Test
    public void insertIncreaseTheSizeOfQueue() {
        QueueTestItem item = new QueueTestItem(1, 1);
        queue.insert(item);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void maximumReturnsElementFromQueue() {
        QueueTestItem item = new QueueTestItem(123, 456);
        queue.insert(item);
        QueueItem<Integer, Integer> maximum = queue.maximum();
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(123, (int)maximum.getKey());
        Assert.assertEquals(456, (int)maximum.getPriority());
    }

    @Test
    public void extractMaximum() {
        QueueTestItem item = new QueueTestItem(123, 456);
        queue.insert(item);
        queue.extractMaximum();
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void getMaximumTest() {
        int count = 3;
        for (int i = 1; i <= count; ++i) {
            queue.insert(new QueueTestItem(i, i));
        }
        for (int i = 1, priority = count; i <= count; ++i, --priority) {
            QueueItem<Integer, Integer> maximum = queue.extractMaximum();
            Assert.assertEquals(count - i, queue.size());
            Assert.assertEquals(priority, (int) maximum.getPriority());
            Assert.assertEquals(priority, (int) maximum.getKey());
        }
    }

    @Test
    public void addRemoveTest() {
        queue.insert(new QueueTestItem(11, 1));
        queue.insert(new QueueTestItem(22, 2));
        queue.insert(new QueueTestItem(33, 3));
        QueueItem<Integer, Integer> maximum = queue.extractMaximum();
        Assert.assertEquals(3, (int) maximum.getPriority());
        Assert.assertEquals(33, (int) maximum.getKey());
        queue.insert(new QueueTestItem(44, 4));
        queue.insert(new QueueTestItem(55, 5));
        maximum = queue.extractMaximum();
        Assert.assertEquals(5, (int) maximum.getPriority());
        Assert.assertEquals(55, (int) maximum.getKey());
    }

    @Test
    public void increaseKeyTest() {
        queue.insert(new QueueTestItem(11, 1));
        queue.insert(new QueueTestItem(22, 2));
        queue.insert(new QueueTestItem(33, 3));
        queue.increaseKey(new QueueTestItem(11, 10));
        QueueItem<Integer, Integer> maximum = queue.extractMaximum();
        Assert.assertEquals(10, (int) maximum.getPriority());
        Assert.assertEquals(11, (int) maximum.getKey());
        queue.insert(maximum);
        queue.increaseKey(new QueueTestItem(22, 20));
        maximum = queue.extractMaximum();
        Assert.assertEquals(20, (int) maximum.getPriority());
        Assert.assertEquals(22, (int) maximum.getKey());
    }

    @Test
    public void increaseKeyForSingleElement() {
        queue.insert(new QueueTestItem(10, 1));
        queue.increaseKey(new QueueTestItem(10, 2));
        QueueItem<Integer, Integer> maximum = queue.extractMaximum();
        Assert.assertEquals(2, (int) maximum.getPriority());
        Assert.assertEquals(10, (int) maximum.getKey());
    }

    @Test
    public void notDecreaseKey() {
        queue.insert(new QueueTestItem(10, 1));
        queue.increaseKey(new QueueTestItem(10, 0));
        QueueItem<Integer, Integer> maximum = queue.extractMaximum();
        Assert.assertEquals(1, (int) maximum.getPriority());
        Assert.assertEquals(10, (int) maximum.getKey());
    }
}

