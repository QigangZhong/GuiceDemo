package com.qigang.consoleApplication;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.qigang.consoleApplication.annotation.CustomAnnotation1;
import com.qigang.consoleApplication.annotation.CustomAnnotation2;
import com.qigang.consoleApplication.dao.Dao;
import com.qigang.consoleApplication.dao.DaoImpl1;
import com.qigang.consoleApplication.dao.DaoImpl2;
import com.qigang.consoleApplication.service.TestService;
import com.qigang.consoleApplication.service.TestServiceImpl;

public class TestModule extends AbstractModule {
    protected void configure() {
        //一个接口单个实现
        this.bind(TestService.class).to(TestServiceImpl.class).asEagerSingleton();

        //一个接口多个实现的时候，通过annotation来区分，分开来注入
        this.bind(Dao.class).annotatedWith(CustomAnnotation1.class).to(DaoImpl1.class);
        this.bind(Dao.class).annotatedWith(CustomAnnotation2.class).to(DaoImpl2.class);

        //names注解常量绑定--也可用于一个接口多个实现的绑定
        this.bindConstant().annotatedWith(Names.named("maxResults")).to(10);

        //将标记名称为CA2的接口注入为DaoImpl2实现类
        this.bind(Dao.class).annotatedWith(Names.named("CA2")).to(DaoImpl2.class);
    }
}
