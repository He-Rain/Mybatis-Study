package com.kuang.dao;

import com.kuang.poro.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
//    UserDao<=>mapper
   //查询全部用户
    @Select("select * from mybatis.user")
    List<User> getUserList();
    //方法存在多个参数，所有的参数前面必须加上@Param("")注解,如果是一个参数可以忽略不加也行，加上也行，建议加上。
    @Select("select * from user where id=#{id2}")
    User getUserById(@Param("id2") int id);
//   User getUserById(@Param("id") int id ,@Param("name") String name);
   @Insert("insert into mybatis.user values(#{id},#{name},#{pwd})")
    int addUser(User user);
   @Update("update  mybatis.user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);
   @Delete("delete from user where id=#{uid}")
    int deleteUser(@Param("uid") int id);
}
