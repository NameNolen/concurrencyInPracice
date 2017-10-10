package chapter3;

import base.GuardeBy;
import base.ThreadSafe;

/**
 * 通过对get和set等方法进行同步可以使方法成为线程安全的类。
 * 仅对set方法进行同步使不够的，调用get的线程仍然会看到失效的值。
 */
@ThreadSafe
public class SynchronizedInteger {
    @GuardeBy("this") private int value;
    public synchronized int get(){return value;}
    public synchronized void set(int value){this.value = value;}
}
