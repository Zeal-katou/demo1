package com.example.user.mapper;

import com.example.user.pojo.dto.UserUpdateDto;
import com.example.user.pojo.entity.User;
import com.example.user.pojo.vo.UserVO;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username,password,role) values (#{username},#{password},#{role})")
    int insert(User user);

    @Delete("delete from user where id=#{id}")
    int deleteById(int id);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    int update(UserUpdateDto userUpdateDto);

    @Select("select * from user where username=#{username}")
    UserVO selectByUsername(String username);

    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where username like (concat('%',#{username},'%'))")
    List<User> selectSearch(String username);

    @Select("select count(*) from user where username=#{username} and password=#{password}")
    int selectByAdd(User user);

    @Select("select * from user where id=#{id}")
    UserUpdateDto selectById(int id);
}
