package com.javatask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class CharsFromFile implements Runnable {

    private Buffer buffer;
    private final Reader reader;

    CharsFromFile(Reader reader) throws FileNotFoundException {
        this.reader = reader;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int c = 0;
            while ((c = reader.read()) != -1 || buffer.getInterrupted()) {
                buffer.put(c);
            }
            buffer.put(-1);
            reader.close();
            buffer.readDone();
        } catch (IOException e) {
            buffer.setInterrupted();
            buffer.readDone();
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
