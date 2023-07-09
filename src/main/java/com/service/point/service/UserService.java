package com.service.point.service;

import com.service.point.entity.User;
import com.service.point.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;
    public Optional<User> getUsersByPhone(String phone){
        return userRepository.findByPhone(phone);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void addUsers(User user){
        if(userRepository.findByPhone(user.getPhone()).isPresent()) throw new IllegalStateException("phone taken");
        else userRepository.save(user);
    }
    public void deleteUsers(User user){
        userRepository.delete(user);
    }
    @Transactional
    public User updateUser(Long id, User user){
        User userTemp = this.userRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "user with id " + id + " does not exists"));
        if(userRepository.findByPhone(user.getPhone()).isPresent()) throw new IllegalStateException("phone taken");
        else{
            userTemp.setPhone(user.getPhone());
            userTemp.setName(user.getName());
            userTemp.setPassword(user.getPassword());
        }
        return userTemp;
    }
}

