package com.isoft.dbutils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {

 static    public SqlSession getSessionFactory(){
        InputStream resourceAsStream =MyBatisUtils.class.getResourceAsStream("../../../configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return  sqlSessionFactory.openSession();
    }
}
