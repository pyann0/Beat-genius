package com.example.Beatgenius.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<D> {
    Page<D> findAll(Pageable pageable);
    Optional<D> findById(long id);
    D saveOrUpdate(D dto);
    void deleteById(long id);
}
