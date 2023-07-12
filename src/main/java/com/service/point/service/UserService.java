package com.service.point.service;

import com.service.point.entity.User;
import com.service.point.exception.ValidPostException;
import com.service.point.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Transactional
    public ResponseEntity<String> addUsers(User user){
        if (userRepository.findByPhone(user.getPhone()).isPresent()) throw new ValidPostException("phone taken");
        else userRepository.save(user);
        return ResponseEntity.ok("registration was success");
    }
    @Transactional
    public ResponseEntity<String> deleteUsers(UUID id){
        User userTemp = this.userRepository.findById(id).orElseThrow(() -> new ValidPostException(
                "user with id " + id + " does not exists"));
        userRepository.delete(userTemp);
        return ResponseEntity.ok("deactivate was success");
    }
    @Transactional
    public ResponseEntity<String> updateUser(UUID id, User user){
        User userTemp = this.userRepository.findById(id).orElseThrow(() -> new ValidPostException(
                "user with id " + id + " does not exists"));
        if(userRepository.findByPhone(user.getPhone()).isPresent()) throw new ValidPostException("phone taken");
        else{
            userTemp.setPhone(user.getPhone());
            userTemp.setName(user.getName());
            userTemp.setPassword(user.getPassword());
        }
        return ResponseEntity.ok("update was success");
    }
}

