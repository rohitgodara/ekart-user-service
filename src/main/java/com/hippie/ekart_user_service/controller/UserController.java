package com.hippie.ekart_user_service.controller;

import com.hippie.ekart_user_service.entity.Users;
import com.hippie.ekart_user_service.model.UserModel;
import com.hippie.ekart_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody UserModel user) {
        Users persistedUser = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persistedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Users user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
