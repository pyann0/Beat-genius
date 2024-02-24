package com.example.Beatgenius.business.instrumentale;

import com.example.Beatgenius.generic.GenericMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface InstrumentaleMapper extends GenericMapper<InstrumentaleDto, Instrumentale> {

    @Override
    @Mapping(source = "catalogue.id", target="catalogueId")
    @Mapping(source = "user.id", target="userId")
    InstrumentaleDto toDto(Instrumentale entity);


    @Override
    @InheritInverseConfiguration
    Instrumentale toEntity(InstrumentaleDto dto);

    @Override
    @InheritInverseConfiguration
    Instrumentale partialUpdate(InstrumentaleDto dto, @MappingTarget Instrumentale entity);
}
