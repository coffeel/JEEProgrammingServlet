package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by yonglinx on 8/22/16.
 */
@WebServlet(name = "AutoRefreshPageServlet")
public class AutoRefreshPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setIntHeader("Refresh", 3);

        String currentDateAndTime = (new Date()).toString();
        PrintWriter out = response.getWriter();
        out.println(currentDateAndTime);
    }
}
