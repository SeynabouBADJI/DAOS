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

import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.ECService;
import com.uasz.demo.Service.Maquette.UEService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")
public class ECController {
    @Autowired
    private ECService ecService;

    @GetMapping(path = "/ec")
    public List lister_ec(){
        return ecService.afficherToutEC();
    }

    // @PostMapping(path = "/ec")
    // public EC ajouter_ec(@RequestBody EC ec){
    //     return ecService.ajouterEC(ec);
    // }

    // @PutMapping(path = "/ec/{id}")
    // public UE modifier_ec(@RequestBody EC ec){
    //     return ecService.modifierEC(ec);
    // }

    @DeleteMapping(path = "/ec/{id}")
    public void supprimer_ec( EC ec){
         ecService.supprimerEC(ec);
    }
    
}
