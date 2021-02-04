package com.gayathri.concurrency;

public class ThreadVariable {

	public static void main(String[] args) {
		Countdown countdown = new Countdown();
		// How can we solve this thread Interference?
		// Give each thread its own object
		// synchronize the method
		// synchronize critical section of the code
		CountdownThread t1 = new CountdownThread(countdown);
		t1.setName("Thread 1");
		CountdownThread t2 = new CountdownThread(countdown);
		t2.setName("Thread 2");

		t1.start();
		t2.start();
	}
}

class Countdown {

	private int i;

	public void doCountdown() {
		String local = "local ";

		// synchronized (this) {
		for (i = 10; i > 0; i--) {
			System.out.println(Thread.currentThread().getName() + ": i =" + i);
		}
		// }

	}
}

class CountdownThread extends Thread {
	private Countdown threadCountdown;

	public CountdownThread(Countdown countdown) {
		threadCountdown = countdown;
	}

	@Override
	public void run() {
		threadCountdown.doCountdown();
	}
}