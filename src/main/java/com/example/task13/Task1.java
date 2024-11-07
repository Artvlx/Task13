package com.example.task13;

public class Task1 {
    public static void main(String[] args) {
        Thread timerThread = new Thread(() -> {
            int seconds = 0;
            try {
                while (true) {
                    System.out.println("Час, що минув: " + seconds + " секунд");
                    Thread.sleep(1000);
                    seconds++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread messageThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        timerThread.start();
        messageThread.start();
    }
}