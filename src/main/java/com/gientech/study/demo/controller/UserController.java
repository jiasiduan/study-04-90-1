package com.gientech.study.demo.controller;

import com.gientech.study.demo.dto.UserDto;
import com.gientech.study.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GetUserById
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) throws IOException {
        return userService.getUserById(id);
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
    @GetMapping("/user")
    public List<UserDto> getUsers(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("pageNo") Integer pageNo) throws IOException {
        return userService.getUsers(name, age, pageSize, pageNo);
    }
}
