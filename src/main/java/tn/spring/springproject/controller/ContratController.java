package tn.spring.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springproject.entities.Contrat;
import tn.spring.springproject.services.IContratServices;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ContratController {


    IContratServices contratServices;

    @GetMapping("/getAllContrat")
    public List<Contrat> getAllContrat(){
        return contratServices.getALLContrat();
    }

    @GetMapping("getContrat/{idContrat}")
    public Contrat getContrat(@PathVariable Integer idContrat){return contratServices.getContratById(idContrat);}

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat c){return contratServices.addContrat(c);}

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat c){return contratServices.updateContrat(c);}

    @DeleteMapping("deleteContrat/{idContrat}")
    public void deleteContrat(@PathVariable Integer idContrat){contratServices.deleteContrat(idContrat);}

    @PostMapping("/affectContratToEtudiant/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, String nomE,@PathVariable String prenomE){

        return contratServices.affectContratToEtudiant(ce,nomE,prenomE);

    }

   @GetMapping("getCA/{Ds}/{Df}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("Ds") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@PathVariable("Df") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return contratServices.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }

    @GetMapping("/getValide/{DateDebutContrat}/{DateFinContrat}")
    public Integer GetValide(@PathVariable("DateDebutContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateD, @PathVariable("DateFinContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateF){

        return  contratServices.nbContratsValides(dateD,dateF);
    }


}
