package tn.spring.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.springproject.entities.Equipe;
import tn.spring.springproject.entities.Etudiant;
import tn.spring.springproject.entities.Niveau;
import tn.spring.springproject.services.IEquipeServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeController {


    IEquipeServices equipeServices;

    @GetMapping("/getAllEquipes")
    public List<Equipe> getallEquipes(){return equipeServices.getAllEquipes();}

    @GetMapping("/getEquipe/{idEquipe}")
    public Equipe getEquipe(@PathVariable Integer idEquipe){return equipeServices.getEquipe(idEquipe);}

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e){return equipeServices.addEquipe(e);}

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e){return equipeServices.updateEquipe(e);}

    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public void deleteEquipe(@PathVariable Integer idEquipe){equipeServices.deleteEquipe(idEquipe);}

    @GetMapping("/findEquipeByThematique/{thematique}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable ("thematique") String th){
        return equipeServices.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @GetMapping("/findEquipeByEtudiant/{idEtudiant}")
    public List<Equipe> findEquipeByEtudiantIdEtudiant(@PathVariable ("idEtudiant") Long id){
        return equipeServices.findEquipeByEtudiantsIdEtudiant(id);
    }

    @GetMapping("/findEquipeByThematiqueNotNull/{idE}")
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull (@PathVariable("idE") Long idEtudiant){
        return equipeServices.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/findByEtudiantAndDepart/{idE}/{idD}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement (@PathVariable("idE") Long idEtudiant,@PathVariable("idD") Integer idDepart){
        return equipeServices.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(idEtudiant,idDepart);
    }

    @GetMapping("/findEquipeByNiveauAndThematique/{niv}/{th}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niv")Niveau niveau ,@PathVariable("th") String thematique){
        return equipeServices.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }

    @DeleteMapping("/deleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable Niveau niveau){
        equipeServices.deleteEquipeByNiveau(niveau);
    }
}
