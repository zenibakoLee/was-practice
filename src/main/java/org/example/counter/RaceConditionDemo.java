package org.example.counter;

public class RaceConditionDemo {
    /**
     * 멀티스레드 환경에서 하나의 자원(싱글톤)이 상태를 갖게 하고, 공유사용하게 되면 레이스 컨디션 발생.
     *
     * @param args
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(counter, "Thread-" + i);
            thread.start();
        }
    }
}
