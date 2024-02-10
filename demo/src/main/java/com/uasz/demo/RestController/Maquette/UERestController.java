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

import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.UEService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/maquette")
public class UERestController {
    @Autowired
    private UEService ueService;

    @GetMapping(path = "/ue")
    public List lister_ue(){
        return ueService.lister_UE();
    }

    @GetMapping(path = "/ue/{id}")
    public UE rechercher_ue(@PathVariable Long id){
        return ueService.rechercher_UE(id);
    }

    @PostMapping(path = "/ue")
    public UE ajouter_ue(@RequestBody UE ue){
        return ueService.ajouter_UE(ue);
    }

    @PutMapping(path = "/ue/{id}")
    public UE modifier_ue(@RequestBody UE ue,@PathVariable Long id){
        return ueService.modifier_UE(ue, id);
    }

    @DeleteMapping(path = "/ue/{id}")
    public void supprimer_ue(@PathVariable Long id){
         ueService.supprimer_UE(id);
    }
    
}
