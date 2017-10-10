package chapter3;

import base.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * 在不可变对象的内部仍可以使用可变对象来管理他们的状态：
 * 如本例
 * 尽管保存姓名的Set对象是可变的，但从ThreeStooges的这几中可以看到，
 * 在Set对象构造完成后无法对其进行修改。stooges是一个final类型的引用变量，
 * 因此所有的对象状态都通过一个final域来访问。
 * 最后一个要求是‘正确地构造对象’，这个要求很容已满足，因为构造函数能使该引用
 * 由除了构造函数及其调用者之外的代码来访问。
 */
@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges(){
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }
    public boolean isStooge(String name){
        return stooges.contains(name);
    }
}
