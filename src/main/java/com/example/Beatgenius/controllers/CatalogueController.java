package com.example.Beatgenius.controllers;

import com.example.Beatgenius.entities.Catalogue;
import com.example.Beatgenius.entities.User;
import com.example.Beatgenius.services.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue")
public class CatalogueController {
    private final CatalogueService service;

    @GetMapping
    public List<Catalogue> findAll() {
        return service.findAll();
    }

    public Catalogue insert(@RequestBody Catalogue catalogue){
        return service.insert(catalogue);

    }
}
