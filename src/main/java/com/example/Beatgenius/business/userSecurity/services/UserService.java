package com.example.Beatgenius.business.userSecurity.services;

import com.example.Beatgenius.business.userSecurity.dtos.UserDto;
import com.example.Beatgenius.business.userSecurity.dtos.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Page<UserDto> findAll(Pageable pageable);
    Optional<UserDto> findById(long id);
    UserDto saveOrUpdate(UserDto dto);
    void deleteById(long id);
}
