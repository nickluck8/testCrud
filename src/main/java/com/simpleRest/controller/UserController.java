package com.simpleRest.controller;

import com.simpleRest.model.dto.UserDto;
import com.simpleRest.model.entity.User;
import com.simpleRest.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/secured/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "hello from user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody @NotNull UserDto userDto) {
        return userService.createUser(userDto);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public User editUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) throws NotFoundException {
        return userService.editUser(id, userDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getUsersPaging(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        PageImpl<User> resultPage = userService.findPaginated(page, size);

        return resultPage.getContent();
    }

}
