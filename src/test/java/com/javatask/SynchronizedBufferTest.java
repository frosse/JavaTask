package com.javatask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.Thread.State;

import org.junit.jupiter.api.Test;

public class SynchronizedBufferTest {

	@Test
	public void testBufferIsFullWaitBeforeAdding() throws InterruptedException {
		SynchronizedBuffer buffer = new SynchronizedBuffer(1);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					buffer.put(55);
					buffer.put(55);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		thread.join(10);
		assertEquals(State.WAITING, thread.getState());
	}

	@Test
	public void testBufferIsEmptyWaitBeforeTaking() throws InterruptedException {
		SynchronizedBuffer buffer = new SynchronizedBuffer(1);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					buffer.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		thread.join(10);
		assertEquals(State.WAITING, thread.getState());
	}
}
