package com.example.Beatgenius.services;

import com.example.Beatgenius.entities.Instrumentale;
import com.example.Beatgenius.entities.Instrumentale;
import com.example.Beatgenius.repositories.InstrumentaleRepository;
import com.example.Beatgenius.repositories.InstrumentaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstrumentaleService {
    private final InstrumentaleRepository repository;
    @Autowired
    private InstrumentaleRepository instrumentaleRepository;
    public List<Instrumentale> findAll() {
        return repository.findAll();
    }
    public Instrumentale getById(long id) {
        Optional<Instrumentale> optional = repository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }

        return null;
    }
    public Instrumentale saveOrUpdate(Instrumentale instrumentale){
        return repository.save(instrumentale);
    }
    public void delete(long id){
        repository.deleteById(id);
    }
    public Instrumentale insert(Instrumentale instrumentale) {
        return instrumentaleRepository.save(instrumentale);
    }
}
