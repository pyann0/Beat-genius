package com.example.Beatgenius.repositories;

import com.example.Beatgenius.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
