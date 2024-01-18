package com.example.Beatgenius.controllers;

import com.example.Beatgenius.entities.Instrumentale;
import com.example.Beatgenius.services.InstrumentaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("instrumentale")
public class InstrumentaleController {
    private final InstrumentaleService service;
    @GetMapping
    public List<Instrumentale> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Instrumentale getById(@PathVariable("id") long id) {
        return service.getById(id);
    }
    @PostMapping("/save")
    public Instrumentale insert(@RequestBody Instrumentale instrumentale){
        return service.insert(instrumentale);

    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        service.delete(id);
    }
}
