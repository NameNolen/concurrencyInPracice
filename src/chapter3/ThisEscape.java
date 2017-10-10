package chapter3;

import java.awt.*;
import java.util.EventListener;

/**
 * 逸出：
 * 当ThisEscape发布EventListener时，
 * 也隐含地发布了ThisEscape实例本身，
 * 因为在这个内部类的实例中包含了对ThisEscape实例的隐含引用。
 */
public class ThisEscape {
    public ThisEscape(EventSource source){
        source.registerListener(new EventListener(){
            public void onEvent(Event e){
                //do somethig
            }
        });
    }
}
class EventSource{
    void registerListener(EventListener eventListener){
        //do somethig
    }
}