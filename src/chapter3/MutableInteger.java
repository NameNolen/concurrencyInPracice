package chapter3;

import base.NotThreadSafe;

/**
 * 非线程安全的，因为get和set都是在没有同步的情况下访问value的。
 * 与其他问题相比，失效的问题更容易出现：
 * 如果某个线程调用了set，那么另一个正在调用get的线程可能会看到更新后的值，也可能看不到。
 */
@NotThreadSafe
public class MutableInteger {
    private int value;
    public int get(){return this.value;}
    public void set(int value){this.value = value;}
}
