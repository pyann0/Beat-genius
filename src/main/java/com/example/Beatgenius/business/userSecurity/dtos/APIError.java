package com.example.Beatgenius.business.userSecurity.dtos;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public class APIError {
    HttpStatus code;
    String message;
}
