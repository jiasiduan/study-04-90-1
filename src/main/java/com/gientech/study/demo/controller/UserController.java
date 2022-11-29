package com.gientech.study.demo.controller;

import com.gientech.study.demo.dto.UserDto;
import com.gientech.study.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    /**
     * GetUsers
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
            @RequestParam("pageNo") Integer pageNo) {
        return userService.getUsers(name, age, pageSize, pageNo);
    }

    /**
     * SaveUser
     * @param userDto
     * @return
     */
    @PostMapping("/user/")
    public Integer saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    /**
     * UpdateUserById
     * @param id
     * @param userDto
     * @return
     */
    @PutMapping("/user/{id}")
    public Integer updateUserById(@PathVariable("id") Integer id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        return userService.updateUserById(userDto);
    }

    /**
     * DeleteUserById
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public Integer deleteUserById(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
    }
}
