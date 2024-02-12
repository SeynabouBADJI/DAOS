package com.uasz.demo.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  libelle;
    private String cours;
    private int duree;
    private String objectifs;
    private  String description;
    private Date datecreation;
    @ManyToOne
    private EC ec;
    @ManyToOne
    private UE ue;
}
