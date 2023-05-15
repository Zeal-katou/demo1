package com.example.user.service;

import com.example.user.pojo.User;

import java.util.List;


public interface UserService {
    //添加用户
    int add(User user);

    void deleteById(int id);

    void update(User user);

    User selectByUsername(String username);

    List<User> selectAll();

    List<User> selectById(String username);

    User checkUserByUsernameAndPassword(String username, String password);
}
