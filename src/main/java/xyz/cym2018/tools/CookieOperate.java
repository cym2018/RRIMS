package xyz.cym2018.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieOperate {
    final HttpServletResponse httpResponse;
    HttpServletRequest httpRequest;
    private Integer cookieMaxAge = 4 * 60 * 60;
    private String cookiePath = "/";
    private Cookie cookie;

    public CookieOperate(HttpServletResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Autowired
    public CookieOperate(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") HttpServletResponse httpResponse, HttpServletRequest httpRequest) {
        this.httpResponse = httpResponse;
        this.httpRequest = httpRequest;
    }

    public CookieOperate CreateCookie(String name, String value) {
        cookie = new Cookie(name, value);
        cookie.setMaxAge(cookieMaxAge);
        cookie.setPath(cookiePath);
        httpResponse.addCookie(cookie);
        return this;
    }

    public CookieOperate RemoveAllCookies() {
        Cookie[] cookies = httpRequest.getCookies();
        for (Cookie i : cookies) {
            i.setPath("/");
            i.setMaxAge(0);
            httpResponse.addCookie(i);
        }
        return this;
    }

    public CookieOperate RemoveCookie(String name) {
        cookie = new Cookie(name, name);
        cookie.setMaxAge(0);
        cookie.setPath(cookiePath);
        httpResponse.addCookie(cookie);
        return this;
    }

    // 刷新cookie有效期
    public CookieOperate Refresh() {
        Cookie[] cookies = httpRequest.getCookies();
        for (Cookie i : cookies) {
            i.setPath("/");
            i.setMaxAge(cookieMaxAge);
            httpResponse.addCookie(i);
        }
        return this;
    }
}
