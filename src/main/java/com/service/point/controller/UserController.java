package com.service.point.controller;

import com.service.point.entity.User;
import com.service.point.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping
    public void addUsers(@RequestBody User user){
        userService.addUsers(user);
    }
    @DeleteMapping
    public void deleteUser(@RequestBody User user){
        userService.deleteUsers(user);
    }
}
