package com.example.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.example.mybatis.dto.BbsDto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IBbsDao {

    public List<BbsDto> listDao();
    public BbsDto viewDao(String id);
    public int wirteDao(Map<String, String> map);
    public int delteDao(@Param("_id")String id);
    public int articleCount();

}