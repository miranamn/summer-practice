package com.service.point.controller;

import com.service.point.entity.User;
import com.service.point.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{phone}")
    public Optional<User> getUsers(@PathVariable("phone") String phone){
        return userService.getUsersByPhone(phone);
    }
    @PostMapping
    public void addUsers(@RequestBody @Valid User user){
        userService.addUsers(user);
    }
    @DeleteMapping
    public void deleteUser(@RequestBody User user){
        userService.deleteUsers(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody @Valid User user){
       return userService.updateUser(id, user);
    }
}
