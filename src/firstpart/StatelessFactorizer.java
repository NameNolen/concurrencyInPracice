package firstpart;

import base.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 同大多数servlet相同，StatelessFactorizer是无状态的：
 * 它不包含任何域，也不包含任何其他类中域的引用；
 * 如果为它添加任何域并且处理状态，就会变为线程不安全的。
 */
@ThreadSafe
public class StatelessFactorizer implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    @ThreadSafe
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = BigInteger.ONE;

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
