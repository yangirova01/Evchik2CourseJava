package ru.itis.springbootdemo.services;

import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.dto.UserForm;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    UserDto addUser(UserForm userForm);
}

