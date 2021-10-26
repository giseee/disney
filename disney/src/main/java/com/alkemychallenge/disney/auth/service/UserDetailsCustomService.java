package com.alkemychallenge.disney.auth.service;

import com.alkemychallenge.disney.auth.dto.UserDto;
import com.alkemychallenge.disney.auth.entity.UserEntity;
import com.alkemychallenge.disney.auth.repository.UserRepository;
import com.alkemychallenge.disney.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserDetailsCustomService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("Username or Password not found");
         }
        return new User(userEntity.getUsername(),userEntity.getPassword(), Collections.emptyList());
    }
    public boolean save(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity= this.userRepository.save(userEntity);
        if(userEntity != null)
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
    }
}
