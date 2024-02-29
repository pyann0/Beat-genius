package com.example.Beatgenius.business.catalogue;

import com.example.Beatgenius.generic.AbstractGenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogues")
public class CatalogueRestController extends AbstractGenericRestController<CatalogueDto, CatalogueService> {
    public CatalogueRestController(CatalogueService service) {
        super(service);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Override
    protected ResponseEntity<CatalogueDto> saveOrUpdate(CatalogueDto dto) {
        return super.saveOrUpdate(dto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Override
    protected void deleteById(long id) {
        super.deleteById(id);
    }
}
