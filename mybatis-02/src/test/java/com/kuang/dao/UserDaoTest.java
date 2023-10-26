package com.kuang.dao;

import com.kuang.poro.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public  void test(){
        //第一步：获取 SqlSession对象
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
}
