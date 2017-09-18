package com.qigang.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.qigang.servlet.MyServlet;

/**
 * 这个filter的目的是配置servlet和filter注入
 */
public class GoogleGuiceServletContextListener extends GuiceServletContextListener {

    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule(){
            @Override
            protected void configureServlets() {
                //在这里注册这个Servlet之后，web.xml中就不需要注册了
                serve("/my").with(MyServlet.class);
                //filter("/*").through(MyFilter.class);
            }
        });
    }
}
