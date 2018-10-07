package com.simpleRest.service.impl;

import com.simpleRest.model.dto.UserDto;
import com.simpleRest.model.entity.User;
import com.simpleRest.repository.UserRepository;
import com.simpleRest.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @PreAuthorize("hasAuthority('USER_READ')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @PreAuthorize("hasAuthority('USER_WRITE')")
    public User deleteUser(Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    @PreAuthorize("hasAuthority('USER_WRITE')")
    public User editUser(Long id, UserDto userDto) throws NotFoundException {
        User user = userRepository.findUserById(id);
        if(Objects.isNull(user)){
            throw new NotFoundException("User does not exist");
        }
        Optional.ofNullable(userDto.getUsername()).ifPresent(user::setUsername);
        Optional.ofNullable(userDto.getPassword()).ifPresent(user::setPassword);

        return userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('USER_WRITE')")
    public User createUser(UserDto userDto) {
        User user = new User();
        Optional.ofNullable(userDto.getUsername()).ifPresent(user::setUsername);
        Optional.ofNullable(userDto.getPassword()).ifPresent(user::setPassword);
        userRepository.save(user);
        return user;
    }
}
