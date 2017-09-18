package com.qigang.consoleApplication;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.qigang.consoleApplication.dao.TestDaoInjection;
import com.qigang.consoleApplication.service.TestService;

/**
 * 独立应用中使用Guice注入
 * http://www.cnblogs.com/huzi007/p/5798688.html
 */
public class App {
    public static void main(String[] args) {
        //普通注入
        Injector inj = Guice.createInjector(new TestModule());
        //TestService service = inj.getInstance(TestService.class);
        //service.testMethod();

        //annotation注入
        TestDaoInjection test = inj.getInstance(TestDaoInjection.class);
        test.test();
    }
}
