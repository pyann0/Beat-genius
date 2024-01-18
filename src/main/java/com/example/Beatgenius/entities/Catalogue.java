package com.example.Beatgenius.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Catalogue extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "catalogue")
    private List<Instrumentale> instrumentales ;
}
