package com.example.Beatgenius.business.userSecurity.models;

import com.example.Beatgenius.business.instrumentale.Instrumentale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean active;

    @ElementCollection
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Instrumentale> instrumentales ;


}
