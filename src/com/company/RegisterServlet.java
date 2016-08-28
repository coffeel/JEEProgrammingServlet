package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yonglinx on 8/19/16.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HandleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("GETing");
        HandleRequest(request, response);
    }

    private void HandleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("POSTing");
        String userName = request.getParameter("userName");
        String passwd = request.getParameter("password");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobbies");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("languages");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<div>");
        out.println("<p>User name: " + userName + "</p>");
        out.println("<p>Password: " + passwd + "</p>");
        out.println("<p>Sex: " + gender + "</p>");
        out.println("<p>Hobbies: </p>");
        for (String hobby : hobbies) {
            out.println(hobby + "<br>");
        }
        out.println("<p>Country: " + country + "</p>");
        out.println("<p>Languages Known: </p>");
        for (String language : languages) {
            out.println(language + "<br>");
        }
    }
}
