package com.aiexpanse.algo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {

    public static void main(String[] args) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        List<Thread> threads = new ArrayList<>();
        CountDownLatch done = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                    longAdder.add(1L);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                done.countDown();
            }));
        }
        threads.forEach(Thread::start);
        done.await();
        System.out.println(longAdder.sum());
    }

}
