package com.uasz.demo.RestController.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.demo.Modele.Maquette.Modules;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.ModulesService;
import com.uasz.demo.Service.Maquette.UEService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")
public class ModulesController {
    @Autowired
    private ModulesService modulesService;

    @GetMapping(path = "/modules")
    public List lister_modules(){
        return modulesService.lister_Modules();
    }

    @GetMapping(path = "/modules/{id}")
    public Modules rechercher_modules(@PathVariable Long id){
        return modulesService.rechercher_Modules(id);
    }

    @PostMapping(path = "/modules")
    public Modules ajouter_modules(@RequestBody Modules modules){
        return modulesService.ajouter_Modules(modules);
    }

    @PutMapping(path = "/modules/{id}")
    public Modules modifier_modules(@RequestBody Modules modules,@PathVariable Long id){
        return modulesService.modifier_Modules(modules, id);
    }

    @DeleteMapping(path = "/modules/{id}")
    public void supprimer_modules(@PathVariable Long id){
         modulesService.supprimer_Modules(id);
    }
    
}
