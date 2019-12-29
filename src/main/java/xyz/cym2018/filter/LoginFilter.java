package xyz.cym2018.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.cym2018.controller.SessionOperate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends SessionOperate implements Filter {
    private Logger logger = LogManager.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        session=request.getSession();
        if (getUserID() == 0) {
            logger.warn("未登录,触发拦截 xyz.cym2018.filter.LoginFilter");
            response.sendRedirect("/login.jsp");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
