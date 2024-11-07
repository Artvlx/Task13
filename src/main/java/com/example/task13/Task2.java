package com.example.task13;

import java.util.Queue;

import java.util.concurrent.LinkedBlockingQueue;

public class Task2 {
	private final int n;
	private final Queue<String> queue = new LinkedBlockingQueue<>();

	public Task2(int n) {
		this.n = n;
	}

	public void fizz() throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				queue.add("fizz");
			}
		}
	}

	public void buzz() throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0 && i % 3 != 0) {
				queue.add("buzz");
			}
		}
	}

	public void fizzbuzz() throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				queue.add("fizzbuzz");
			}
		}
	}

	public void number() throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 3 != 0 && i % 5 != 0) {
				queue.add(String.valueOf(i));
			}
			System.out.println(queue.poll());
		}
	}

	public static void main(String[] args) {
		int n = 15;
		Task2 task = new Task2(n);

		Thread threadA = new Thread(() -> {
			try {
				task.fizz();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread threadB = new Thread(() -> {
			try {
				task.buzz();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread threadC = new Thread(() -> {
			try {
				task.fizzbuzz();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread threadD = new Thread(() -> {
			try {
				task.number();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();
	}
}