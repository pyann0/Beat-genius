package com.example.Beatgenius.business.userSecurity.dtos;

import com.example.Beatgenius.business.instrumentale.InstrumentaleDto;
import lombok.Value;

import java.util.List;

@Value
public class UserDto {

    Long id;
    int version;
    String username;
    String email;
    List<InstrumentaleDto> instrumentales;
}
