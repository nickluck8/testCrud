package com.simpleRest.service.impl;

import com.simpleRest.model.dto.UserDto;
import com.simpleRest.model.entity.User;
import com.simpleRest.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import com.simpleRest.repository.UserRepository;
import com.simpleRest.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    public User editUser(Long id, UserDto userDto) {
        User user = userRepository.findUserById(id);
        Optional.ofNullable(userDto.getFirstName()).ifPresent(user::setFirstName);
        Optional.ofNullable(userDto.getSecondName()).ifPresent(user::setSecondName);
        Optional.ofNullable(userDto.getRole()).ifPresent(user::setRole);

        return userRepository.save(user);
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User(userDto.getFirstName(), userDto.getSecondName(), userDto.getUserName(), userDto.getRole());
        if(user.getRole() == null){
            user.setRole(Role.USER);
        }
        userRepository.save(user);
        return user;
    }
}
