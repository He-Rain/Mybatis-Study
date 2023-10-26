package com.kuang.dao;

import com.kuang.poro.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    //      Logger获取当前类反射对象
//    参数为当前类的class
static Logger logger=Logger.getLogger(UserDaoTest.class);
    @Test
    //使用注解开发,底层主要应用反射。
    public  void test(){
        //第一步：获取 SqlSession对象
        logger.info("info:进入了test测试方法成功");
        SqlSession sqlSession= MybatisUtils.getSqlSession();
 //执行sql
        //方式一
     UserMapper mapper= sqlSession.getMapper(UserMapper.class);
     List<User> userList =mapper.getUserList();
     //方式二：
//        List<User>  userList=sqlSession.selectList("com.kuang.dao.UserMapper.getUserList");
    for (User user:userList ){
        System.out.println(user);
    }
        //关闭SqlSession
        sqlSession.close();
    }
@Test
public  void getUserById(){
    SqlSession sqlSession= MybatisUtils.getSqlSession();

    UserMapper mapper= sqlSession.getMapper(UserMapper.class);
       User userList =mapper.getUserById(1);
        System.out.println(userList);
    sqlSession.close();
}
    @Test
    public  void addUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
         mapper.addUser(new User(6,"Hello","123456"));
        sqlSession.close();
    }
    @Test
    public  void updateUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(6,"哈哈","123123"));
        sqlSession.close();
    }
    @Test
    public  void deleteUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);
        sqlSession.close();
    }
@Test
    public void testlog4j(){
//        info 信息的意思 一些提示信息用  debug 放在调试语句用  error 紧急错误用
    //这些都是日志级别 相当于System.out,println()这个输出文件。
        logger.info("info:进入了testlog4j");
        logger.debug("debug:进入了testlog4j");
        logger.error("error:进入了testlog4j");
}
}
