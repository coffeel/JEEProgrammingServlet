package com.company;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yonglinx on 8/19/16.
 */
@WebServlet("/HelloWorld")
public class HelloWorldServlet extends GenericServlet {


    public HelloWorldServlet() {
        super();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter out=servletResponse.getWriter();
        out.println("JEE: Programming Servlet. Hello World!!");
    }
}
