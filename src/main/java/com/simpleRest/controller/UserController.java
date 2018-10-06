package com.simpleRest.controller;

import com.simpleRest.model.dto.UserDto;
import com.simpleRest.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.simpleRest.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "hello from user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(UserDto userDto){
        return userService.createUser(userDto);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PATCH)
    public User editUser(Long id, UserDto userDto) {
        return userService.editUser(id, userDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@RequestParam("id") Long id) {
        return userService.deleteUser(id);
    }
}
