package com.example.car.service;

import com.example.car.dto.UserDto;
import com.example.car.entity.User;
import com.example.car.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(String id, String password){
        return userRepository.findByIdAndPassword(id, password);
    }

    public boolean signup(UserDto userDto){
        try{
            User user = User.builder()
                    .id(userDto.getId())
                    .password(userDto.getPassword1())
                    .name(userDto.getName())
                    .email(userDto.getEmail())
                    .build();

            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
