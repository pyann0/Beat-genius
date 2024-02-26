package com.example.Beatgenius.business.userSecurity.mappers;

import com.example.Beatgenius.business.instrumentale.InstrumentaleMapper;
import com.example.Beatgenius.business.userSecurity.dtos.RegisterDto;
import com.example.Beatgenius.business.userSecurity.dtos.UserDto;
import com.example.Beatgenius.business.userSecurity.models.User;
import org.mapstruct.Mapper;

@Mapper(uses = {InstrumentaleMapper.class})
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
    User toEntity(RegisterDto dto);
}
