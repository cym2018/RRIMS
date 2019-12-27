package xyz.cym2018.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    Logger logger = LogManager.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        try {
            session.getAttribute("userID").toString();
        } catch (Exception e) {
            logger.warn("未登录,触发拦截 xyz.cym2018.filter.LoginFilter");
            response.sendRedirect("/login.jsp");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
