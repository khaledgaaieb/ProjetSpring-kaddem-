package tn.spring.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springproject.entities.Equipe;
import tn.spring.springproject.entities.Etudiant;
import tn.spring.springproject.entities.Option;
import tn.spring.springproject.services.IEtudiantServices;

import java.util.List;
import java.util.Set;


@RestController
@AllArgsConstructor
public class EtudiantController {

    IEtudiantServices etudiantServices;

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant() {
        return etudiantServices.getALLEtudiant();
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantServices.addEtudiant(e);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updatEtudiant(@RequestBody Etudiant e) {
        return etudiantServices.updateEtudiant(e);
    }

    @DeleteMapping("/deleteEtudiant/{idEtudiant}")
    void deleteETudiant(@PathVariable Long idEtudiant) {
        etudiantServices.deleteETudiant(idEtudiant);
    }

    @GetMapping("/getEtudiant/{idEtudiant}")
    public Etudiant getEtudiant(@PathVariable Long idEtudiant) {
        return etudiantServices.getEtudiantById(idEtudiant);
    }

    @GetMapping("/getEtudiantByPrenom/{PrenomEtudiant}")
    public Etudiant getEtudiantbyPrenomEtudiant(@PathVariable String PrenomEtudiant) {
        return etudiantServices.getEtudiantbyPrenomEtudiant(PrenomEtudiant);
    }

    @GetMapping("/getEtudiantbyEquipThematic/{thematique}")
    public List<Etudiant> retrieveEtudiantByEquipeThematique (@PathVariable String thematique){
        return etudiantServices.retrieveEtudiantByEquipeThematique(thematique);
    }

    @PutMapping("/updateEtudiantByOption/{op}/{idE}")
    public void updateEtudiantByOption(@PathVariable("op") Option op,@PathVariable("idE") Long idEtudiant){
        etudiantServices.updateEtudiantByOption(op, idEtudiant);
    }

    @PutMapping("/assignEtudiantToDepartement/{idEtudiant}/{idDepartement}")
    public void assignEtudiantToDepartement(@PathVariable Long idEtudiant,@PathVariable Integer idDepartement){
        etudiantServices.assignEtudiantToDepartement(idEtudiant,idDepartement);
    }

    @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idEquipe}/{idContrat}")
    @ResponseBody
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idEquipe") Integer idEquipe ,@PathVariable("idContrat") Integer idContrat){
        return etudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idEquipe,idContrat);

    }

    @GetMapping("/getEtudiantByDepartement/{idD}")
    public Set<Etudiant> getEtudiantByDepartement(@PathVariable("idD") Integer idDepartement){
        return etudiantServices.getEtudiantByDepartement(idDepartement);
    }
}
