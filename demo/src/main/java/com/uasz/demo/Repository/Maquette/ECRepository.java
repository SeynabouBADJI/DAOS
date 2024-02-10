package com.uasz.demo.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;

public interface ECRepository extends JpaRepository<EC,Long>{
    

    
}
