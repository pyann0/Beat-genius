package com.example.Beatgenius.business.userSecurity.dtos;

import lombok.Value;

@Value
public class UserDto {

    Long id;
    int version;
    String username;
    String email;
}
