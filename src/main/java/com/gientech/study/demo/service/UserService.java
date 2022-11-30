package com.gientech.study.demo.service;

import com.gientech.study.demo.component.RedisComponent;
import com.gientech.study.demo.dto.UserDto;
import com.gientech.study.demo.mapper.UserMapper;
import com.gientech.study.demo.struct.UserStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;


@Service
@Slf4j
public class UserService {

    private UserMapper userMapper;

    private RedisComponent redisComponent;

    @Autowired
    private UserService(UserMapper userMapper, RedisComponent redisComponent) {
        this.userMapper = userMapper;
        this.redisComponent = redisComponent;
    }

    /**
     * GetUserById
     *
     * @param id
     * @return
     */
    public UserDto getUserById(Integer id) throws IOException {
        StringJoiner stj = new StringJoiner("-", "getUserById-", "");
        stj.add(String.valueOf(id));
        boolean res = redisComponent.hasKey(stj.toString());
        if (res) return redisComponent.get(stj.toString(), UserDto.class);
        UserDto userDto = UserStruct.INSTANCE.toDto(userMapper.getUserById(id));
        redisComponent.set(stj.toString(), userDto, 20);
        return userDto;
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
    public List<UserDto> getUsers(String name, Integer age, Integer pageSize, Integer pageNo) throws IOException {
        StringJoiner stj = new StringJoiner("-", "getUsers-", "");
        stj.add(String.valueOf(pageSize));
        stj.add(String.valueOf(pageNo));
        stj.add(String.valueOf(name));
        stj.add(String.valueOf(age));
        boolean res = redisComponent.hasKey(stj.toString());
        if (res) return redisComponent.get(stj.toString(), List.class);
        List<UserDto> userDtos = UserStruct.INSTANCE.toDto(userMapper.getUsers(name, age, (pageNo - 1) * pageSize, pageSize));
        redisComponent.set(String.valueOf(stj.toString()), userDtos, 20);
        return userDtos;
    }

}
