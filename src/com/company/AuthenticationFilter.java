package com.company;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by yonglinx on 8/24/16.
 */
@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    public void destroy() {
        System.out.println("destroy method is called in " + this.getClass().getName());
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter method is called in " + this.getClass().getName());

        String userName = req.getParameter("username");
        String passwd = req.getParameter("passwd");
        String ipAddress = req.getRemoteAddr();

        if(userName.equals("psuser")&& passwd.equals("psguest")){
            System.out.println("User logged in "+ ipAddress+" at "+new Date().toString());
            chain.doFilter(req, resp);
        }
        else{
            PrintWriter out=resp.getWriter();
            out.println("<h3>Sorry, You are not authorized to access this resource</h3>");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init method is called in " + this.getClass().getName());
    }

}
