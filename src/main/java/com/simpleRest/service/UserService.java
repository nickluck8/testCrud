package com.simpleRest.service;

import com.simpleRest.model.dto.UserDto;
import com.simpleRest.model.entity.User;
import javassist.NotFoundException;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User deleteUser(Long id);

    User editUser(Long id, UserDto userDto) throws NotFoundException;

    User createUser(UserDto userDto);

    PageImpl<User> findPaginated(Integer page, Integer size);
}
