package com.kuang.dao;

import com.kuang.poro.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
public User queryUserById(@Param("id") int id);
@Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
public  int updateUser(User user);
}
