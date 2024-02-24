package com.example.Beatgenius.business.userSecurity.controllers;

import com.example.Beatgenius.business.userSecurity.dtos.LoginDto;
import com.example.Beatgenius.business.userSecurity.dtos.LoginResponseDto;
import com.example.Beatgenius.business.userSecurity.dtos.RegisterDto;
import com.example.Beatgenius.business.userSecurity.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final AuthService service;

    //@RequestMapping(value = "login", method = {RequestMethod.POST})
    @PostMapping("login")
    public LoginResponseDto authenticate(@RequestBody LoginDto credential) {
        return service.authenticate(credential);
    }

    @PostMapping("register")
    public void register(@RequestBody RegisterDto dto) {
        service.register(dto);
    }
}
