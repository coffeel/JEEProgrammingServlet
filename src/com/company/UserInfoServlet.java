package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by yonglinx on 8/19/16.
 */
@WebServlet(name = "UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameter
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        out.println("<h3>Reading QueryString data using 'String getParameter(String name)' method: </h3>");
        out.println("<div>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("</div>");

        //get parameter names
        out.println("<div>");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            out.println("<p>" + paramName + " : " + paramValue + "</p>");
        }
        out.println("</div>");

        //get parameter map
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> paramNamesSet = parameterMap.keySet();
        out.println("<div>");
        paramNamesSet.forEach(paramName -> {
            out.print("<p>" + paramName + ":");
            Arrays.asList(parameterMap.get(paramName)).forEach(v -> out.println(v));
            out.print("</p>");
        });
        out.println("</div>");
    }
}
