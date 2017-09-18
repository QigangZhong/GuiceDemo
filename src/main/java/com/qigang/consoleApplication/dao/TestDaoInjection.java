package com.qigang.consoleApplication.dao;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.qigang.consoleApplication.annotation.CustomAnnotation1;
import com.qigang.consoleApplication.annotation.CustomAnnotation2;

@Singleton
public class TestDaoInjection {
    private Dao dao1;

    @Inject
    @CustomAnnotation2
    private Dao dao2;//通过annotation注入指定实现类

    @Inject
    @Named("CA2")
    private Dao namedDao;//通过name注入指定实现类, 在module中指定具有该名称的接口注入为哪个实现类

    @Inject
    public void setDao1(@CustomAnnotation1 Dao dao1) {//通过annotation注入指定实现类
        this.dao1 = dao1;
    }

    private int maxResults;

    @Inject
    public void setMaxResults(@Named("maxResults") int maxResults) {//按名称绑定
        this.maxResults = maxResults;
    }

    public void test(){
        System.out.println("开始测试注入...");
        dao1.testGuice();
        dao2.testGuice();
        namedDao.testGuice();
        System.out.println(maxResults);
    }
}
