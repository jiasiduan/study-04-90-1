package com.gientech.study.demo.mapper;

import com.gientech.study.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public
interface UserMapper {

    @Select("select * from user where id=#{id}")
    UserEntity getUserById(Integer id);
}
