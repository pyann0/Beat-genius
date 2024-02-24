package com.example.Beatgenius.business.catalogue;

import com.example.Beatgenius.generic.AbstractGenericRestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogues")
public class CatalogueRestController extends AbstractGenericRestController<CatalogueDto, CatalogueService> {
    public CatalogueRestController(CatalogueService service) {
        super(service);
    }
}
