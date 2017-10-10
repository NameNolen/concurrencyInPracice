package firstpart;

import base.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 一定不可以这么做：
 * 尽管使用原子引用本身是线程安全的，但是其中存在竞态条件，使程序产生错误;
 *
 */
@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {
    //AtomicReference 是一种替代对象引用的线程安全类。类似AtomicLong;
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();
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
        if(i.equals(lastNumber.get())){
            //some calculate;
        } else {
            BigInteger[] factors = new BigInteger[10];
            lastNumber.set(i);
            lastFactors.set(factors);
            //some calculate;
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
