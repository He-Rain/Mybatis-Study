package com.kuang.dao;

import com.kuang.poro.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Test
    public void getUserById(){
//第一步：获取 SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper= sqlSession.getMapper(UserMapper.class);//相当于这个操作UserMapper mapper=new UserMapperImpl();
        User user=mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
//   增删改查都需要提交事务，函数/方法才能执行成功。
    @Test
    public void addUser(){
        //第一步：获取 SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //执行sql
        //方式一
        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(6,"哈哈","123456"));
       //提交事务
//        sqlSession.commit();
       sqlSession.close();
    }
    @Test
    public void addUser1(){
        //第一步：获取 SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //执行sql
        //方式一
        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
       int res=mapper.addUser1(new User(6,"哈哈","123456"));
       if(res>0){
           System.out.println("执行成功");
       }
        //提交事务
       sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void addUser2(){
        //第一步：获取 SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //执行sql
        //方式一
        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("userid",6);
        map.put("password",123456);
        int res=mapper.addUser2(map);
        if(res>0){
            System.out.println("执行成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //执行sql
        //方式一
        UserMapper mapper= sqlSession.getMapper(UserMapper.class);
       mapper.updateUser(new User(4,"呵呵","123123"));
       sqlSession.commit();
        sqlSession.close();
    }
@Test
    public void deletUser(){
    SqlSession sqlSession= MybatisUtils.getSqlSession();
    //执行sql
    //方式一
    UserMapper mapper= sqlSession.getMapper(UserMapper.class);
     mapper.deleteUser(6);
   sqlSession.commit();  //提交事务
    sqlSession.close();
}

}
