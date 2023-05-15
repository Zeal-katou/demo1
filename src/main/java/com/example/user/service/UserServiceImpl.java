package com.example.user.service;
import java.util.List;

import com.example.user.dao.UserDao;
import com.example.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //添加用户
    @Override
    public int add(User user) {
        return userDao.insert(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public List<User> selectById(String username) {
        return userDao.selectSearch(username);
    }

    @Override
    public User checkUserByUsernameAndPassword(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int count = userDao.selectByAdd(user);
        if (count > 0) {
            return userDao.selectByUsername(username);
        } else {
            return null;
        }
    }
}

