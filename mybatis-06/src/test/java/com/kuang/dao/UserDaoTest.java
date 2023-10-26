package com.kuang.dao;

import com.kuang.poro.Student;
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
public  void main(){
   SqlSession sqlSession =MybatisUtils.getSqlSession();
StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
   List<Student> studentList =studentMapper.getStudent1();
    for (Student user:studentList
    ) {
        System.out.println(user);
    }
    sqlSession.close();
}
@Test
public void getStudent(){
SqlSession sqlSession =MybatisUtils.getSqlSession();
StudentMapper studentMapper =sqlSession.getMapper(StudentMapper.class);
List<Student> studentList =studentMapper.getStudent();
    for (Student user:studentList
         ) {
        System.out.println(user);
    }
sqlSession.close();
}
@Test
public void getStudent2(){
    SqlSession sqlSession =MybatisUtils.getSqlSession();
    StudentMapper studentMapper =sqlSession.getMapper(StudentMapper.class);
    List<Student> studentList =studentMapper.getStudent2();
    for (Student user:studentList
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
