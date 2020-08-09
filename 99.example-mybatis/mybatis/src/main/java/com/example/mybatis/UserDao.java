package com.example.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserDto> list() {

        String sql = "SELECT * FROM user";
        List<UserDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDto>(UserDto.class));

        return list;
    }

}