package com.qigang.service;


import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestScoped
public class MyServiceImpl implements MyService {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Inject
    public MyServiceImpl(HttpServletRequest req, HttpServletResponse resp, HttpSession ses) {
        request = req;
        response = resp;
        session = ses;
    }

    public void myMethod() throws IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        response.getWriter().append("MyService-MyMethod-------name:" + name + " age:" + age);
    }
}
