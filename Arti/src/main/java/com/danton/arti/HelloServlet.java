package com.danton.arti;

import java.io.*;
import java.util.Map;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Questionnaire", value = "/questionnaire")
public class HelloServlet extends HttpServlet {
    private String message;
    static final String TEMPLATE = "<html>" +
            "<head><title>Questionnaire</title></head>" +
            "<body><h2>%s</h2></body></html>";
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String FirstName = request.getParameter("first");
        String LastName = request.getParameter("last");
        Integer Age = Integer.valueOf(request.getParameter("age"));
        String Employed = String.valueOf(request.getParameter("q1"));
        Integer Answer = Integer.valueOf(request.getParameter("q2"));
        if (Employed.equals("on") || (Answer != 6) || (Age < 18)) {
            response.getWriter().println(String.format(TEMPLATE, "Denied"));
        } else {
            response.getWriter().println(String.format(TEMPLATE, FirstName+" "+LastName+" "+Age+" - Welcome to the company."));
        }

    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//    }

    public void destroy() {
    }
}