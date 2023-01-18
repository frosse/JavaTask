package com.javatask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class CopyOneByOne {
    private final CharsToFile consumer;
    private final CharsFromFile producer;

    CopyOneByOne(String[] args) throws IOException, InvalidArgumentsException {
        CopyProgramArguments arguments = new CopyProgramArguments();
        arguments.parse(args);
        Buffer buffer = new SynchronizedBuffer(arguments.getCapacity());
        File inputFile = new File(arguments.getInputFileName());
        Reader fileReader = new FileReader(inputFile);
        Reader bufferedReader = new BufferedReader(fileReader);
        producer = new CharsFromFile(bufferedReader);

        File outputFile = new File(arguments.getOutputFileName());
        consumer = new CharsToFile(new FileWriter(outputFile));

        this.producer.setBuffer(buffer);
        this.consumer.setBuffer(buffer);
    }

    public void start() {
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }
}
