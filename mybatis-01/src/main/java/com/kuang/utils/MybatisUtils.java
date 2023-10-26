package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

// SqlSessionFactory--> SqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        //使用mybatis 第一步获取 SqlSessionFactory对象
        String resource = "mybatis.config.xml";//获取资源
        InputStream inputStream=null ;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//注意这里sqlSessionFactory的前面没有这个SqlSessionFactory数据类型
    }
//    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。org.apache.ibatis.session.SqlSession
//    提供了在数据库执行 org.apache.ibatis.jdbc.SQL 命令所需的所有方法。
//    你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
public static SqlSession getSqlSession(){
//    SqlSession session=sqlSessionFactory.openSession();
//   return  session;
   return sqlSessionFactory.openSession();
}
}
/*
//SqlSessionFactory -->SqlSession
public class MybatisUtils{

    private static SqlSessionFactory sqlSessionFactory;
    static {

        try {
            //使用Mybaties第一步：获取sqlSessionFactory对象
            String resource = "mybatis.config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    // SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlSession(){
//        SqlSession sqlSession =  sqlSessionFactory.openSession();
//        return sqlSession;

        return sqlSessionFactory.openSession();
    }

}
*/
