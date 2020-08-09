package com.example.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public  interface IUserDao {
    List<UserDto> list();
}