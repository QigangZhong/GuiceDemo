package com.qigang.service;

import com.google.inject.ImplementedBy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ImplementedBy(MyServiceImpl.class)
public interface MyService {
    void myMethod() throws IOException;
}
