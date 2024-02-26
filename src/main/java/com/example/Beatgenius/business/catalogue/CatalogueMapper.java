package com.example.Beatgenius.business.catalogue;

import com.example.Beatgenius.business.instrumentale.InstrumentaleMapper;
import com.example.Beatgenius.generic.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {InstrumentaleMapper.class})
public interface CatalogueMapper extends GenericMapper<CatalogueDto, Catalogue> {
}
