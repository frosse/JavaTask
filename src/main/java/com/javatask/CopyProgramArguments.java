package com.javatask;

public class CopyProgramArguments {
    private String inputFileName;
    private String outputFileName;
    private int capacity;

    public void parse(String[] args) throws InvalidArgumentsException {
        if (args.length > 0) {
            // Should validate file names and handle integer parsing better.
            this.inputFileName = args[0];
            this.outputFileName = args[1];
            this.capacity = Integer.parseInt(args[2]);
        } else {
            throw new InvalidArgumentsException(args);
        }
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public int getCapacity() {
        return capacity;
    }

}
