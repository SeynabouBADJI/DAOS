package com.uasz.demo.Modele.Maquette;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private String description;
    private int coefficient;
    private int credit;
    private String dateCreation;
    @OneToMany( mappedBy = "ue")
    private Collection<EC> ecs;
    @OneToMany(mappedBy = "ue")
    private Collection<Modules> modules;

}
