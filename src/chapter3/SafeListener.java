package chapter3;

import java.awt.*;
import java.util.EventListener;

/**
 * 如果想在构造函数中注册一个时间监听器或启动线程，
 * 那么可以使用一个私有的构造器和一个公共的工厂方法，从而避免不正确的构造过程
 */
public class SafeListener {
    private final EventListener listener;
    private SafeListener(){
        listener = new EventListener(){
          public void onEvent(Event event){
              //do something
          }
        };
    }
    public static SafeListener newInstance(EventSource eventSource){
        SafeListener safe = new SafeListener();
        eventSource.registerListener(safe.listener);
        return safe;
    }
}
