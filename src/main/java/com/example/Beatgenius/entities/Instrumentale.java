package com.example.Beatgenius.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instrumentale extends  BaseEntity{
    private String name;
    private double price;
    @ManyToOne
    private Catalogue catalogue;
    @ManyToOne
    private User user;



}
