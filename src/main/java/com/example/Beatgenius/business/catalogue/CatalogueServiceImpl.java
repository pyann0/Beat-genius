package com.example.Beatgenius.business.catalogue;

import com.example.Beatgenius.generic.AbstractGenericService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CatalogueServiceImpl extends AbstractGenericService<Catalogue, CatalogueDto, CatalogueRepository, CatalogueMapper> implements CatalogueService {
    public CatalogueServiceImpl(CatalogueRepository repository, CatalogueMapper mapper) {
        super(repository, mapper);
    }


}
