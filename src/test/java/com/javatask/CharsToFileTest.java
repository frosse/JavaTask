package com.javatask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

public class CharsToFileTest {

	@Test
	public void testCharsToFile() throws IOException, InterruptedException {
		Buffer buffer = new SynchronizedBuffer(2);
		buffer.put(55);
		buffer.put(55);
		StringWriter writer = new StringWriter();
		CharsToFile underTest = new CharsToFile(writer);
		underTest.setBuffer(buffer);
		Thread thread = new Thread(underTest);
		thread.start();
		thread.join(10);
		assertEquals(2, writer.getBuffer().length());

	}
}
