package com.kuang.dao;

import com.kuang.poro.Teacher;
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
public void getTeacher(){
    SqlSession sqlSession =MybatisUtils.getSqlSession();
    TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
    List<Teacher> teacher=teacherMapper.getTeacher();
    for (Teacher user:teacher
    ) {
        System.out.println(user);
    }
sqlSession.close();
}
@Test
    public void getTeacherstudent(){
        SqlSession sqlSession =MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
    Teacher teacher=teacherMapper.getTeacher1(1);

            System.out.println(teacher);
sqlSession.close();

    }
    @Test
    public void getTeacherstudent1(){
        SqlSession sqlSession =MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.getTeacher2(1);

        System.out.println(teacher);
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
