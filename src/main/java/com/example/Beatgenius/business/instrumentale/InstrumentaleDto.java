package com.example.Beatgenius.business.instrumentale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class InstrumentaleDto {
    private long id;
    private int version;
    private String name;
    private double price;
    private long catalogueId;
    private long userId;
    private String cover;
    private String file;
}
