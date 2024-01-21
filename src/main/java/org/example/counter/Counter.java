package org.example.counter;

public class Counter implements Runnable {
    private int count = 0;

    void increment() {
        this.count++;
    }

    void decrement() {
        this.count--;
    }

    @Override
    public void run() {
//        synchronized (this) { // 동기화 처리
        increment();
        System.out.println(Thread.currentThread().getName() + " After increment: " + count);
        decrement();
        System.out.println(Thread.currentThread().getName() + " After decrement: " + count);
//        }
    }
}
