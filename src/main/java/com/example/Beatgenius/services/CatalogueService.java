package com.example.Beatgenius.services;

import com.example.Beatgenius.entities.Catalogue;
import com.example.Beatgenius.entities.User;
import com.example.Beatgenius.repositories.CatalogueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatalogueService {


    private final CatalogueRepository catalogueRepository;

    public List<Catalogue> findAll() {
        return catalogueRepository.findAll();
    }
    public Catalogue insert(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }
}
