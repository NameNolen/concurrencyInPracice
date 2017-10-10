package firstpart;

import base.NotThreadSafe;

/**
 * 在LazyInitRace中包含了一个竞态条件，
 * 他可能会破坏这个类的正确性。
 */
@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance(){
        if(instance == null){
            instance = new ExpensiveObject();
        }
        return instance;
    }
}

class ExpensiveObject{

}