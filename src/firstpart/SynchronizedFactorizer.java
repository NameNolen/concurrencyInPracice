package firstpart;

import base.GuardeBy;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 线程安全问题虽然解决了，但是会严重影响并发
 */
public class SynchronizedFactorizer implements Servlet {
    @GuardeBy("this") private BigInteger lastNumber;
    @GuardeBy("this") private BigInteger[] lastFactors;

    public SynchronizedFactorizer() {
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = BigInteger.ONE;
        if(i.equals(lastNumber)){
            //some code
        }else {
            //some code
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
