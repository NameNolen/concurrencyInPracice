package firstpart;

import base.GuardeBy;
import base.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

@ThreadSafe
public class CachedFactorizer implements Servlet {
    @GuardeBy("this") private BigInteger lastNumber;
    @GuardeBy("this") private BigInteger[] lastFactors;
    @GuardeBy("this") private long hits;
    @GuardeBy("this") private long cacheHits;
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
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if(i.equals(lastNumber)){
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if(factors==null){
            factors = new BigInteger[]{};
            synchronized (this){
                lastNumber = i;
                lastFactors = factors.clone();
            }
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
