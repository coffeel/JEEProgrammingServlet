package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yonglinx on 8/26/16.
 */
@WebServlet(name = "/Step2")
public class Step2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        //Cookie guestData = new Cookie("guestName", guestName);
        //response.addCookie(guestData);
        HttpSession session = request.getSession();
        session.setAttribute("guestName", guestName);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Greetings</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>" + guestName + "</h3>");
        out.println("<form name='frm' action='Preview' method='Get'");
        out.println("<input type='hidden' name='guestName' value='" + guestName + "'>");
        out.println("<p><input type='email' name='email'/></p>");
        out.println("<p><input type='submit' value='Preview' name='btnPreview'></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
