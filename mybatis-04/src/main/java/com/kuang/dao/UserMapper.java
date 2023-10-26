package com.kuang.dao;

import com.kuang.poro.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    UserDao<=>mapper
   //查询全部用户
    List<User> getUserList();
    //分页
   List<User> getUserByLimit(Map<String,Integer> map);
    //分页2
    List<User> getUserRowBounds();
}
