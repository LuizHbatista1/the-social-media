package com.api.the_social_media.service.user;

import com.api.the_social_media.domain.user.User;
import com.api.the_social_media.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){

       return this.userRepository.findById(id).orElseThrow(RuntimeException::new);

    }
}
