### Java task

This repo contains implementation for simple file copying program.
Program takes file names and buffer capacity as arguments. 
Program reads input file to buffer character by character until buffers capacity is full.
After buffer is full, program starts taking characters one by one from buffer and writes them to output file.
Reading and writing are done on separate thread, and they share character buffer.

### Usage

Program needs three arguments to run. Given in order:
1. input filename
2. output filename
3. buffer capacity
