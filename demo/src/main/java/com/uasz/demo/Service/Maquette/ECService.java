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
    @Autowired
    private static ECRepository ecRepository;
    
     public List<EC> afficherToutEC(){
        return ecRepository.findAll();
    }

   
    public EC afficherEC(Long id){
        return ecRepository.getById(id);
    }

    public  void ajouterEC(EC ec){
         ecRepository.save(ec);
    }
    public void modifierEC (EC ec){
        EC ecUpdate = ecRepository.getById(ec.getId());
        ecUpdate.setCode(ec.getCode());
        ecUpdate.setLibelle(ec.getLibelle());
        ecUpdate.setCm(ec.getCm());
        ecUpdate.setTd(ec.getTd());
        ecUpdate.setTp(ec.getTp());
        ecUpdate.setTpe(ec.getTpe());
        ecUpdate.setCoefficient(ec.getCoefficient());
        ecUpdate.setDescription(ec.getDescription());
        ecUpdate.setUe(ec.getUe());
        ecRepository.save(ecUpdate);

    }
    public void supprimerEC(EC ec ){
        ecRepository.delete(ec);

    }
    


    
}
