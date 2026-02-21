package com.stu.mobile_shop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stu.mobile_shop.domains.User;
import com.stu.mobile_shop.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String handleHello(){
        return "Hello from userService";
    }

    public User handleSaveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getAllUsersbyEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User getUserbyID(Long id){
        User user = userRepository.findById(id)
        .orElseThrow(()->new RuntimeException("User not found"));
        return user;
    }
    public void deleteUserById(Long id) {
    userRepository.deleteById(id);
}

}
