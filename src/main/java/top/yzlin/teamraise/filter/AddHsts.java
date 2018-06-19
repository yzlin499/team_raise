package top.yzlin.teamraise.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddHsts implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        if (request.isSecure()) {
            resp.setHeader("Strict-Transport-Security", "max-age=31536000;includeSubDomains");
        }
        chain.doFilter(request, response);
    }
}
