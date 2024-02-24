package com.example.Beatgenius.business.home;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("public/test")
    public String test(){
        return "Welcome page test";
    }

    @GetMapping("public")
    public String pagpPublic(){
        return"Welcome public";
    }
    @GetMapping()
    public String home(){
        return "Welcome page home";
    }

}
