package firstpart;

import base.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;

/**
 * 这不是一个线程安全的类，它包含一个操作 count++：
 * 这个操作不是原子型的，它包含三个操作：读取count的值，将值加1，然后将计算结果写入count；
 * 类CountingFactorizer可以将实现线程安全
 */
@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {
    private long count = 0;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //some calculate
        ++count;
        //some calculate
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
