package com.example.apifirstapproach.api;

import io.swagger.api.UserApi;
import io.swagger.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserAPI implements UserApi {
    private List<User> users = new ArrayList<>();

    @Override
    public ResponseEntity<User> createUser(User body) {
        users.add(body);
        return ResponseEntity.accepted().body(body) ;
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        return ResponseEntity.ok().body(users.stream().filter(u->u.getUsername().equals(username)).findAny().get());
    }
}
