package com.example.user.dao;

import com.example.user.pojo.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper  // 告诉springboot这是一个mybatis的mapepr类
public interface UserDao {
    //添加用户
    @Insert("insert into user (username,password,role) values (#{username},#{password},#{role})")
    int insert(User user);

    //删除用户
    @Delete("delete from user where id=#{id}")
    int deleteById(int id);

    //修改用户信息
    @Update("update user set username=#{username},password=#{password},role=#{role} where id=#{id}")
    int update(User user);

    //根据用户名查询用户信息
    @Select("select * from user where username=#{username}")
    User selectByUsername(String username);

    //查询所有用户信息
    @Select("select * from user")
    List<User> selectAll();

    //根据用户名进行模糊查询
    @Select("select * from user where username like %#{username}%")
    List<User> selectSearch(String username);

    //根据用户名和密码查询用户信息
    @Select("select count(*) from user where username=#{username} and password=#{password}")
    int selectByAdd(User user);
}