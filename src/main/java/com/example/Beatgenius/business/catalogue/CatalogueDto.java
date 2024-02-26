package com.example.Beatgenius.business.catalogue;

import com.example.Beatgenius.business.instrumentale.InstrumentaleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueDto {
    private long id;
    private int version;
    private String name;
    private List<InstrumentaleDto> instrumentales;


}
