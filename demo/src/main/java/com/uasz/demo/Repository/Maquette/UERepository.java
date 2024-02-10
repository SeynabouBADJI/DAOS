package com.uasz.demo.Repository.Maquette;

import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UERepository extends JpaRepository<UE, Long> {
    @Query("select e FROM EC e WHERE e.ue = ?1")
    List<EC> findByUE(UE ue);
}
