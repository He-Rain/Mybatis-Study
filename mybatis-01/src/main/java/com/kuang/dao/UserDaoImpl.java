package com.kuang.dao;

import com.kuang.poro.User;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserMapper {

    @Override
    public List<User> getUserList() {
        //执行sql语句
//      String  sql="select * from mybatis.user;";
      //执行结果集 Resultset

      return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserById1(int id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public int addUser1(User user) {
        return 0;
    }

    @Override
    public int addUser2(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}
