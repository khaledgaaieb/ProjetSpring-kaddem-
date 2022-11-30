package tn.spring.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tn.spring.springproject.entities.Departement;
import tn.spring.springproject.entities.Option;
import tn.spring.springproject.services.IDepartementServices;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class DepartementController {


    IDepartementServices departementServices;


    @GetMapping("/getDepartement/{idDepart}")
    public Departement getDepartements(@PathVariable Integer idDepart){return departementServices.getDepartementById(idDepart);}

    @GetMapping("/getAllDepartment")
    public List<Departement> getDepartementList(){return departementServices.getAllDepartements();}

    @PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement d){return departementServices.addDepartement(d);}

    @PutMapping("/updateDepartement")
    public Departement updateDepartement(@RequestBody Departement d){return departementServices.updateDepartement(d);}

    @DeleteMapping("/deleteDepartement/{idDepart}")
    public void deleteDepartement(@PathVariable Integer idDepart){departementServices.deleteDepartement(idDepart);}

    @GetMapping("/getDepByEtudOpt/{opt}")
    public List<Departement> retrieveDepartementByOptionEtudiant(@PathVariable Option opt){
        return departementServices.retrieveDepartementByOptionEtudiant(opt);
    }

   @GetMapping("retrieveDepartementByUniversite/{idU}")
    public Set<Departement> retrieveDepartementByUniversite(@PathVariable("idU") Integer idUniversite){
        return departementServices.retrieveDepartementByUniversite(idUniversite);
    }
}
