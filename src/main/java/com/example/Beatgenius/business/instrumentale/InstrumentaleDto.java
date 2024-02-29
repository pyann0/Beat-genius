package com.example.Beatgenius.business.instrumentale;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class InstrumentaleDto {
    private long id;
    private int version;
    private String name;
    private long catalogueId;
    private long userId;
    private String cover;
    private String file;
}
