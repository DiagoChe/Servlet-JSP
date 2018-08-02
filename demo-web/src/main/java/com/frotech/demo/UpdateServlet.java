package com.frotech.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {


    private static final long serialVersionUID = -5611225684579508814L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");

        try {
            new UserService().update(Long.parseLong(idStr), name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/demo");
    }
}
