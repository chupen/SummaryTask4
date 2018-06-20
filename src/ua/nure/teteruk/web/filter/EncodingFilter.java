package ua.nure.teteruk.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter{
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        //HttpServletRequest httpRequest = (HttpServletRequest) request;

        String requestEncoding = request.getCharacterEncoding();
        if (requestEncoding == null) {
            request.setCharacterEncoding(encoding);
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) {
        encoding = fConfig.getInitParameter("encoding");
    }
}
