package com.uasz.demo.Service.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Repository.Maquette.UERepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UEService {
    @Autowired
    private UERepository ueRepository;
    
     public List<UE> lister_UE(){
        return ueRepository.findAll();
    }

    public UE rechercher_UE(Long id){
        return ueRepository.findById(id).get();
    }

    public UE ajouter_UE(UE ue){
        return ueRepository.save(ue);
    }
    public UE modifier_UE (UE ue, Long id){
        ue.setId(id);
        return ueRepository.save(ue);

    }
    public void supprimer_UE(Long id ){
        ueRepository.deleteById(id);

    }
    public List<EC> Lister_EC_UE(UE ue){
        return ueRepository.findByUE(ue);
    }


    
}
