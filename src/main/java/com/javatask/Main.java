package com.javatask;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CopyOneByOne cProgram = new CopyOneByOne(args);
            cProgram.start();
        } catch (InvalidArgumentsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        } catch (IOException e) {
            System.out.println("Error opening output file");
        }

    }
}
