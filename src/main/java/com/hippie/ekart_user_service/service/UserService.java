package com.hippie.ekart_user_service.service;

import com.hippie.ekart_user_service.entity.Users;
import com.hippie.ekart_user_service.exception.UserNotFoundException;
import com.hippie.ekart_user_service.model.UserModel;
import com.hippie.ekart_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

import static com.hippie.ekart_user_service.constant.ErrorMessages.RESOURCE_NOT_FOUND;
import static com.hippie.ekart_user_service.constant.StatusEnum.ACTIVE;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Users create(UserModel user) {
        Users newUser = Users.builder().userName(user.getUserName()).email(user.getEmail())
                .firstName(user.getFirstName()).lastName(user.getLastName())
                .mobile(user.getMobile()).status(ACTIVE.name()).isBlocked(Boolean.FALSE).createdOn(Instant.now().toString())
                .modifiedOn(Instant.now().toString()).build();
        return repository.save(newUser);
    }

    public Users findById(Long id) {
        Optional<Users> user = repository.findById(id);
        user.orElseThrow(() -> new UserNotFoundException(RESOURCE_NOT_FOUND));
        return user.get();
    }
}
