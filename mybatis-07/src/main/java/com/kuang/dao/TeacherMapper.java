package com.kuang.dao;

import com.kuang.poro.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
 //获取老师
  List<Teacher> getTeacher();
//  //获取指定老师下的所有学生及老师的信息
//  @Select("select * from teacher where id=#{tid}")
 Teacher getTeacher1(@Param("tid") int id);
 Teacher getTeacher2(@Param("tid") int id);
}
