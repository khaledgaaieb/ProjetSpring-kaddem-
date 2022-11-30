package tn.spring.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.springproject.entities.Universite;
import tn.spring.springproject.services.IUniversiteServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {

    IUniversiteServices universiteServices;

    @GetMapping("/getAllUniversite")
    public List<Universite> getAllUniverite(){
        return universiteServices.getAllUniversites();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServices.addUniversite(u);
    }

    @PutMapping("/updateUniversite")
    public Universite updatUniversite(@RequestBody Universite u){
        return universiteServices.updateUniversite(u);
    }

    @DeleteMapping("/deleteUniversite/{idUniversite}")
    void deleteUniversite(@PathVariable Integer idUniversite){
        universiteServices.deleteUniversite(idUniversite);
    }

    @GetMapping("/getUniversite/{idUniversite}")
    public Universite getUniversite(@PathVariable Integer idUniversite){
        return universiteServices.getUniversite(idUniversite);
    }

    @PutMapping("/assignUniversiteToDepartement/{idDepartement}/{idUniversite}")
    public void assignUniversiteToDepartement(@PathVariable ("idDepartement") Integer idDepartement,@PathVariable ("idUniversite") Integer idUniversite){
         universiteServices.assignUniversiteToDepartement(idDepartement,idUniversite);
    }

}
