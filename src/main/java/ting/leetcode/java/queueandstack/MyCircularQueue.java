package ting.leetcode.java.queueandstack;

import java.util.Arrays;


public class MyCircularQueue {
    private final int[] queue;
    private int head = -1;
    private int tail = -1;

    public MyCircularQueue(int size) {
        this.queue = new int[size];
        Arrays.fill(queue, -1);
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        if (isEmpty()) {
            tail = 0;
            head = 0;
        }


        queue[tail++] = value;

        if (tail >= queue.length) {
            tail %= queue.length;
        }


        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            head = -1;
            tail = -1;
            return false;
        }

        queue[head++] = -1;

        if (head >= queue.length) {
            head %= queue.length;
        }

        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;

        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        if (tail - 1 < 0) {
            return queue[queue.length - 1];
        }
        return queue[tail - 1];
    }

    public boolean isEmpty() {
        if (head == -1 && head == tail) {
            return true;
        }

        return head == tail && queue[head] == -1;
    }

    public boolean isFull() {
        if (isEmpty())
            return false;

        return head == tail && queue[head] != -1;
    }
}
