package com.service.point.controller;

import com.service.point.entity.User;
import com.service.point.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public ResponseEntity<String> addUsers(@RequestBody @Valid User user){
        return userService.addUsers(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") UUID id){
        return userService.deleteUsers(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") UUID id, @RequestBody @Valid User user){
       return userService.updateUser(id, user);
    }
}
