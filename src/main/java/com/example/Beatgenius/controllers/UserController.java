package com.example.Beatgenius.controllers;

import com.example.Beatgenius.entities.User;
import com.example.Beatgenius.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService service;

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public User insert(@RequestBody User user){
        return service.insert(user);

    }
    public User saveorUpdate(@RequestBody User user){
        return service.saveOrUpdate(user);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        service.delete(id);
    }
}