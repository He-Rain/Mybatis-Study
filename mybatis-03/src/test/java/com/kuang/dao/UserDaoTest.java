package com.kuang.dao;

import com.kuang.poro.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test() {
        //第一步：获取 SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql
        //方式一
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        //方式二：
//        List<User>  userList=sqlSession.selectList("com.kuang.dao.UserMapper.getUserList");

        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    // select * from mybatis.user where id=#{id}
    //类型处理器
    // select id,name,pwd from mybatis.user where id=#{id}
    @Test
    public void getUserById1(){
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper mapper=sqlSession.getMapper(UserMapper.class);
    User user=mapper.getUserById1(1);
    System.out.println(user);
    sqlSession.close();
    }
    @Test
    public void getUserById2() {
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    UserMapper  mapper=sqlSession.getMapper(UserMapper.class);
    User user=mapper.getUserById2(1);
    System.out.println(user);
sqlSession.close();
    }
}