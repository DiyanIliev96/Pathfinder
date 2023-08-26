package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.dto.UserRegisterDto;
import com.example.pathfinder.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void doRegister(UserRegisterDto userRegisterDto) {
        User user = new User();
        boolean isUserExist = isUserExist(userRegisterDto);
        if (!isUserExist) {
            user.setUsername(userRegisterDto.getUsername())
                    .setFullName(userRegisterDto.getFullName())
                    .setPassword(passwordEncoder.encode(userRegisterDto.getPassword()))
                    .setEmail(user.getEmail());
            userRepository.save(user);
        }
    }

    public boolean isUserExist(UserRegisterDto userRegisterDto) {
        return userRepository.existsByUsername(userRegisterDto.getUsername());
    }
}
