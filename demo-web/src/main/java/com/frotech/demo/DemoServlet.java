package com.frotech.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DemoServlet extends HttpServlet {


    private static final long serialVersionUID = -6871250722870054089L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DemoServlet.doPost");

        User user = null;
        try {
            user = new UserService().getUser(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("user", user);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
