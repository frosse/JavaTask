package com.javatask;

import java.io.IOException;
import java.io.Writer;

public class CharsToFile implements Runnable {

    private Buffer buffer;
    private final Writer writer;

    CharsToFile(Writer writer) throws IOException {
        this.writer = writer;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int c = 0;
            while (true) {
                c = buffer.take();
                if (c == -1 || buffer.getInterrupted()) {
                    break;
                }
                writer.write(c);
                writer.flush();
            }

            writer.close();
            System.out.println("Characters moved successfully");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
