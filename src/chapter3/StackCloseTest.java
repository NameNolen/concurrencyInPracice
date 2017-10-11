package chapter3;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class StackCloseTest {
    /**
     * 基本类型的局部变量与引用变量的线程封闭性
     * @param candidates
     * @return
     */
    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animales;
        int numPairs = 0;
        Animal candidate = null;

        //animals 被封闭在方法中，不要使他们逸出！
        animales = new TreeSet();
        animales.addAll(candidates);
        for (Animal a : animales) {
            if (candidate == null || !candidates.isEmpty()) {
                candidate = a;
            } else {
                //do something
                ++numPairs;
                candidate = null;
            }
        }
        return numPairs;
    }

}

class Animal {

}