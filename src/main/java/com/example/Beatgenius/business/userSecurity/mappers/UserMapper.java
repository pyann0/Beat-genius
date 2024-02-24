package com.example.Beatgenius.business.userSecurity.mappers;

import com.example.Beatgenius.business.userSecurity.dtos.RegisterDto;
import com.example.Beatgenius.business.userSecurity.dtos.UserDto;
import com.example.Beatgenius.business.userSecurity.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
    User toEntity(RegisterDto dto);
}
