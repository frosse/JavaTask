package com.javatask;

public interface Buffer {

    void put(int element) throws InterruptedException;

    int take() throws InterruptedException;

    void readDone();


    void setInterrupted();

    boolean getInterrupted();

}
