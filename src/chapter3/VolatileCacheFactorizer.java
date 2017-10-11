package chapter3;

import base.Immutable;
import base.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 因式分解Servlet将执行两个原子操作：更新缓存的结果，以及通过判断缓存中的数值是否等于请求的
 * 是指来决定是否直接读取缓存中的因数分解结果。每当需要对一组香瓜数据以原子方式执行某个操作是，就可以考虑
 * 创建一个不可变的类来包含这些数据。如本例：
 */
@Immutable
class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    OneValueCache(BigInteger i, BigInteger[] factors) {
        this.lastNumber = i;
        this.lastFactors = factors;
    }

    BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}

/**
 * 使用OneValueCache进行缓存，保持不变性。
 */
@ThreadSafe
public class VolatileCacheFactorizer implements Servlet {
    private volatile OneValueCache cache = new OneValueCache(null,null);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = BigInteger.ONE;
        BigInteger[] factors = cache.getFactors(i);
        if(factors == null){
            factors = new BigInteger[]{BigInteger.ONE,BigInteger.TEN};
            cache = new OneValueCache(i, factors);//进行因数分解的缓存
        }
        //some code
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}