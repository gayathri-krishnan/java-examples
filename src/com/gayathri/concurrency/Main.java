package com.gayathri.concurrency;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello from the main thread.");

		final Thread anotherThread = new AnotherThread();
		anotherThread.setName("== Another Thread ==");
		anotherThread.start();

		new Thread() {
			@Override
			public void run() {
				System.out.println("Hello from the anonymous class thread");
			}
		}.start();

		Thread myRunnableThread = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println("Hello from the anonymous class's implementation of run()");
				try {
					anotherThread.join(); // wait for another thread
					System.out.println("AnotherThread terminated, or timed out, so I'm running again");
				} catch (InterruptedException e) {
					System.out.println("I couldn't wait after all. I was interrupted");
				}
			}
		});

		myRunnableThread.start();

		System.out.println("Hello again from the main thread.");

	}
}
