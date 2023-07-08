package com.service.point.service;

import com.service.point.entity.User;
import com.service.point.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void addUsers(User user){
        userRepository.save(user);
    }
    public void deleteUsers(User user){
        userRepository.delete(user);
    }
}

