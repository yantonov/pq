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
        Assert.assertNull(queue.minimum());
    }

    @Test
    public void insertIncreaseTheSizeOfQueue() {
        QueueTestItem item = new QueueTestItem(1, 1);
        queue.insert(item);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void minimumReturnsElementFromQueue() {
        QueueTestItem item = new QueueTestItem(123, 456);
        queue.insert(item);
        QueueItem<Integer, Integer> minimum = queue.minimum();
        Assert.assertEquals(1, queue.size());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(123, (int) minimum.getKey());
        Assert.assertEquals(456, (int) minimum.getPriority());
    }

    @Test
    public void extractMaximum() {
        QueueTestItem item = new QueueTestItem(123, 456);
        queue.insert(item);
        queue.extractMinimum();
        Assert.assertEquals(0, queue.size());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void getMinimumTest() {
        int count = 3;
        for (int i = 1; i <= count; ++i) {
            queue.insert(new QueueTestItem(i, i));
        }
        for (int i = 1, priority = 1; i <= count; ++i, ++priority) {
            QueueItem<Integer, Integer> maximum = queue.extractMinimum();
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
        QueueItem<Integer, Integer> maximum = queue.extractMinimum();
        Assert.assertEquals(1, (int) maximum.getPriority());
        Assert.assertEquals(11, (int) maximum.getKey());
        queue.insert(new QueueTestItem(44, 4));
        queue.insert(new QueueTestItem(55, 5));
        maximum = queue.extractMinimum();
        Assert.assertEquals(2, (int) maximum.getPriority());
        Assert.assertEquals(22, (int) maximum.getKey());
    }

    @Test
    public void decreaseKeyForMultipleElements() {
        queue.insert(new QueueTestItem(11, 1));
        queue.insert(new QueueTestItem(22, 2));
        queue.insert(new QueueTestItem(33, 3));
        queue.decreaseKey(new QueueTestItem(11, -1));
        QueueItem<Integer, Integer> maximum = queue.minimum();
        Assert.assertEquals(-1, (int) maximum.getPriority());
        Assert.assertEquals(11, (int) maximum.getKey());
        queue.insert(maximum);
        queue.decreaseKey(new QueueTestItem(22, -2));
        maximum = queue.extractMinimum();
        Assert.assertEquals(-2, (int) maximum.getPriority());
        Assert.assertEquals(22, (int) maximum.getKey());
    }

    @Test
    public void decreaseKeyForSingleElement() {
        queue.insert(new QueueTestItem(10, 1));
        queue.decreaseKey(new QueueTestItem(10, 0));
        QueueItem<Integer, Integer> maximum = queue.extractMinimum();
        Assert.assertEquals(0, (int) maximum.getPriority());
        Assert.assertEquals(10, (int) maximum.getKey());
    }

    @Test
    public void notIncreaseKey() {
        queue.insert(new QueueTestItem(10, 1));
        queue.decreaseKey(new QueueTestItem(10, 2));
        QueueItem<Integer, Integer> maximum = queue.extractMinimum();
        Assert.assertEquals(1, (int) maximum.getPriority());
        Assert.assertEquals(10, (int) maximum.getKey());
    }
}

