package com.qigang.servlet;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.qigang.service.MyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Servelet不需要在web.xml中配置，直接通过Guice注入
 */
@Singleton
public class MyServlet extends HttpServlet {

    @Inject
    private Injector inj;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyService myService = inj.getInstance(MyService.class);
        myService.myMethod();
        resp.getWriter().append("-------Hello, guice! ---------"+new Date());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
