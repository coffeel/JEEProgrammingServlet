package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by yonglinx on 8/22/16.
 */
@WebServlet(name = "LargeServletPageServlet")
public class LargeServletPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (GzipUtility.isGzipSupported(request) && !GzipUtility.isGzipDisabled(request)) {
            out = GzipUtility.getGzipWriter(response);
            response.setHeader("Content-Encoding", "gzip");
        }

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Demo: Request Headers</title>");
        out.println("</head>");
        out.println("<body>");

        String dummyLine = "vcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewf" +
                "vcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewf" +
                "vcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewf" +
                "vcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewf" +
                "vcz vfewfw fwfiwe fwejnfew fewf" +
                "vcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewf" +
                "vcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewf" +
                "vcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewfvcz vfewfw fwfiwe fwejnfew fewf";
        for (int i = 0; i < 10000; i++) {
            out.println(dummyLine + "</br>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
