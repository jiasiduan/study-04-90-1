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
     * @param pageId
     * @param pageSize
     * @param pageNo
     * @return
     */
    public List<UserDto> getUsers(String name, Integer age, Integer pageId, Integer pageSize, Integer pageNo) {
        return null;
    }

    /**
     * SaveUser
     *
     * @param userDto
     * @return
     */
    public Integer saveUser(UserDto userDto) {
        return 0;
    }

    /**
     * UpdateUserById
     *
     * @param userDto
     * @return
     */
    public Integer updateUserById(UserDto userDto) {
        return 0;
    }

    /**
     * DeleteUserById
     *
     * @param id
     * @return
     */
    public Integer deleteUserById(Integer id) {
        return 0;
    }
}
