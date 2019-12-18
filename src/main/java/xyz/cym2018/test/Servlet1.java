package xyz.cym2018.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

//        super.doGet(req, resp);
        System.out.println("123");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
//        super.doPost(req, resp);
        System.out.println("456");
    }
}
