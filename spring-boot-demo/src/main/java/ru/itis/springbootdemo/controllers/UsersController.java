package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.dto.UserForm;
import ru.itis.springbootdemo.services.UsersService;
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "users_page";
    }

    // GET users/3
    @GetMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(usersService.getUserById(userId));
    }
    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<UserDto> addUser(@RequestBody UserForm userForm) {
        return ResponseEntity.ok(usersService.addUser(userForm));
    }

}
