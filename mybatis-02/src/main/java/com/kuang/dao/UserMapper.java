package com.kuang.dao;

import com.kuang.poro.User;

import java.util.List;

public interface UserMapper {
//    UserDao<=>mapper
   //查询全部用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    User getUserById1(int id);
    //insert一个用户
    void addUser(User user);
    int addUser1(User user);
    //修改用户
     void  updateUser(User user);
    //删除用户
    int deleteUser(int id);

}
