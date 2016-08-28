package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yonglinx on 8/26/16.
 */
@WebServlet(name = "Preview")
public class Preview extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Preview</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>" + guestName + "</h3>");
        out.println("<h3>" + email + "</h3>");
        out.println("</body>");
        out.println("</html>");
    }
}
