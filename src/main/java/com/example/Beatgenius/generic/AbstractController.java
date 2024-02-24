package com.example.Beatgenius.generic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public abstract class AbstractController<D,S extends GenericService<D>> {
    protected final String path;
    protected final S service;


    @GetMapping
    public String all(Model model) {
        // Model permet la transmission d'informations entre le programme et le template
        model.addAttribute("elements", service.findAll(Pageable.unpaged()));
        return path + "/all";
    }
    @CrossOrigin
    @GetMapping("{id}")
    public String findById(@PathVariable long id, Model model) {
        // Model permet la transmission d'informations entre le programme et le template
        model.addAttribute("element", service.findById(id).orElseGet(this::getDTO));
        return path + "/byId";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute("element") D dto) {
        service.saveOrUpdate(dto);
        return "redirect:/"+path;
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable long id) {
        service.deleteById(id);
        return "redirect:/" + path;
    }

    @ModelAttribute("path")
    public String getPath() {
        return path;
    }

    protected abstract D getDTO(); // une methode abstraite force les classe qui étendent celle-ci à fournir le code nécessaire
}
