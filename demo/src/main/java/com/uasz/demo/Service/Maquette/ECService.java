package com.uasz.demo.Service.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Repository.Maquette.ECRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ECService {
    private final ECRepository ecRepository;

    @Autowired
    public ECService(ECRepository ecRepository) {
        this.ecRepository = ecRepository;
    }
    
    public List<EC> afficherToutEC(){
        return ecRepository.findAll();
    }

    public EC afficherEC(Long id){
        return ecRepository.getById(id);
    }

    public EC rechercherEC(Long id){
        return ecRepository.findById(id).get();
    }

    public EC ajouterEC(EC ec){
         return ecRepository.save(ec);
    }

    public EC modifierEC (EC ec, Long id){
        ec.setId(id);
        return ecRepository.save(ec);
    }

    public void supprimerEC(Long id ){
        ecRepository.deleteById(id);
    }
}
