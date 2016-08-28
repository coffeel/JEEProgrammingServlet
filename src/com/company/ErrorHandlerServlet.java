package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yonglinx on 8/24/16.
 */
@WebServlet(name = "ErrorHandlerServlet")
public class ErrorHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
        String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        PrintWriter out = response.getWriter();
        out.println(statusCode + " " + errorMessage + " " + requestURI + " " + servletName);
    }
}
