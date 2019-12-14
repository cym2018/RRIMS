package servlet;

import test.LoggerTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
//        super.doGet(req, resp);
        System.out.println("123");
        LoggerTest.main(null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
//        super.doPost(req, resp);
        System.out.println("456");
    }
}
