package com.uasz.demo.Service.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.demo.Modele.Maquette.Modules;
import com.uasz.demo.Repository.Maquette.ModulesRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ModulesService {
    @Autowired
    private ModulesRepository modulesRepository;
    
     public List<Modules> lister_Modules(){
        return modulesRepository.findAll();
    }

    public Modules rechercher_Modules(Long id){
        return modulesRepository.findById(id).get();
    }

    public Modules ajouter_Modules(Modules modules){
        return modulesRepository.save(modules);
    }
    public Modules modifier_Modules (Modules modules, Long id){
        modules.setId(id);
        return modulesRepository.save(modules);

    }
    public void supprimer_Modules(Long id ){
        modulesRepository.deleteById(id);

    }
   


    
}
