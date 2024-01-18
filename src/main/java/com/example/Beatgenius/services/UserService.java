package com.example.Beatgenius.services;

import com.example.Beatgenius.entities.User;
import com.example.Beatgenius.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User getById(long id) {
        Optional<User> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public User insert(User user){
        return repository.save(user);
    }

    public User update(User user){
        return repository.save(user);
    }
    public User saveOrUpdate(User user){
        return repository.save(user);
    }
    public void delete(long id){
        repository.deleteById(id);
    }
}