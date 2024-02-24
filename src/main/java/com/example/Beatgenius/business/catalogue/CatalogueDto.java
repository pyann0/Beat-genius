package com.example.Beatgenius.business.catalogue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueDto {
    private long id;
    private int version;
    private String name;


}
