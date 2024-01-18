package com.example.Beatgenius.repositories;

import com.example.Beatgenius.entities.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
}
