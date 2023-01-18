package com.javatask;

import java.util.Arrays;

class InvalidArgumentsException extends Exception {
    public InvalidArgumentsException(String[] args) {
        super("Invalid arguments given. Expect 'input filename' 'output filename' 'buffer capacity. Got: " + Arrays.toString(args));
    }

}
