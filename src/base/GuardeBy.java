package base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE,ElementType.FIELD})
public @interface GuardeBy {
    String value() default "";
}
