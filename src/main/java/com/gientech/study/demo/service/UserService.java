package com.gientech.study.demo.service;

import com.gientech.study.demo.dto.UserDto;
import com.gientech.study.demo.entity.UserEntity;
import com.gientech.study.demo.mapper.UserMapper;
import com.gientech.study.demo.struct.UserStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    private UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * GetUserById
     *
     * @param id
     * @return
     */
    public UserDto getUserById(Integer id) {
        return UserStruct.INSTANCE.toDto(userMapper.getUserById(id));
    }

    /**
     * GetUsers
     *
     * @param name
     * @param age
     * @param pageSize
     * @param pageNo
     * @return
     */
    public List<UserDto> getUsers(String name, Integer age, Integer pageSize, Integer pageNo) {
        return UserStruct.INSTANCE.toDto(userMapper.getUsers(name, age, (pageNo - 1) * pageSize, pageSize));
    }

}
