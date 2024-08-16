package com.api.the_social_media.service.security.auth;

import com.api.the_social_media.DTOS.RegisterDTO;
import com.api.the_social_media.domain.user.User;
import com.api.the_social_media.repositories.UserRepository;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        var user = userRepository.findByEmail(username);
        return user;
    }

    public UserDetails signUp(RegisterDTO data) throws InvalidJwtException {
        if (userRepository.findByEmail(data.email()) != null) {
            throw new InvalidJwtException("User Already Exist!",null ,null);
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.firstName() , data.email(), encryptedPassword, data.role());
        return userRepository.save(newUser);

    }

}

