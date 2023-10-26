package com.kuang.dao;

import com.kuang.poro.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    //        获取当前类反射对象
//    参数为当前类的class
static Logger logger=Logger.getLogger(UserDaoTest.class);
    @Test
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
    public void getUserBylimit(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
      UserMapper  mapper=sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map =new HashMap<String,Integer>();
       map.put("startIndex",0);
       map.put("pageSize",2);
//        List<User>   userlist=mapper.getUserByLimit(map);
        for (User user:mapper.getUserByLimit(map)
             ) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserByRowBounds(){
 SqlSession sqlSession=MybatisUtils.getSqlSession();
 //RowBounds 实现
      RowBounds rowBounds=new RowBounds(0,2);
 //通过java代码层面实现分页
   List<User>  userList=sqlSession.selectList("com.kuang.dao.UserMapper.getUserRowBounds",null,rowBounds);
        for (User user:userList
             ) {
            System.out.println(user);
        }
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
