package com.javatask;

import java.util.LinkedList;
import java.util.Queue;

class SynchronizedBuffer implements Buffer {

    private final Queue<Integer> queue = new LinkedList<Integer>();
    private boolean empty = true;
    private int capacity;
    private boolean interrupted = false;

    SynchronizedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(int c) throws InterruptedException {
        while (!empty) {
            wait();
        }

        queue.add(c);
        if (queue.size() >= capacity) {
            empty = false;
            notifyAll();
        }
    }

    public synchronized int take() throws InterruptedException {
        while (empty) {
            wait();
        }
        int tmp = queue.remove();
        if (queue.isEmpty()) {
            empty = true;
            notifyAll();
        }
        return tmp;
    }

    public synchronized void readDone() {
        empty = false;
        notifyAll();
    }

    public synchronized void setInterrupted() {
        interrupted = true;
    }

    public boolean getInterrupted() {
        return interrupted;
    }
}
