package test;

import org.junit.Test;

/**
 * 一个importNum公众号上的例子
 */
public class ConcurrencyTest {

    public static void main(String[] args) {
        demo3();
    }

    private static void demo1() {
        Thread a = new Thread(() -> printNumber("a"));
        Thread b = new Thread(() -> printNumber("b"));
        a.start();
        b.start();
    }

    public static void demo2() {
        Thread a = new Thread(() -> printNumber("a"));
        Thread b = new Thread(() -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printNumber("b");
        });
        a.start();
        b.start();
    }

    private static void demo3() {
        Object lock = new Object();
        Thread a = new Thread(() -> {
            synchronized (lock) {

                System.out.println("a 1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a 2");
                System.out.println("a 3");
            }
        });
        Thread b = new Thread(() -> {
            synchronized (lock) {
                System.out.println("b 1");
                System.out.println("b 2");
                System.out.println("b 3");
                lock.notify();
            }
        });
        a.start();
        b.start();
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print:" + i);
        }
    }
}
