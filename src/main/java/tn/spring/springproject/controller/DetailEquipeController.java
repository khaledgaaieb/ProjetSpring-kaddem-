package tn.spring.springproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springproject.entities.DetailEquipe;
import tn.spring.springproject.entities.Equipe;
import tn.spring.springproject.services.IDetailEquipeServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class DetailEquipeController {


    IDetailEquipeServices detailEquipeServices;

    @GetMapping("/getALLDetailEquipe")
    public List<DetailEquipe> getallDetailEquipes(){return detailEquipeServices.GetAllDetailEquipe();}

    @GetMapping("/getDetailEquipe/{idDetailEquipe}")
    public DetailEquipe getDetailEquipe(@PathVariable Integer idDetailEquipe){return detailEquipeServices.getDetailEquipeById(idDetailEquipe);}

    @PostMapping("/addDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e){return detailEquipeServices.addDetailEquipe(e);}

    @PutMapping("/updateDetailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe e){return detailEquipeServices.updateDetailEquipe(e);}

    @DeleteMapping("/deleteDetailEquipe/{idDetailEquipe}")
    public void deleteDetailEquipe(@PathVariable Integer idDetailEquipe){detailEquipeServices.deleteDetailEquipe(idDetailEquipe);}

    @GetMapping("/getDetailEquipeByThematique/{Thematic}")
    public List<DetailEquipe> findByThematique(@PathVariable String Thematic){return detailEquipeServices.findByThematique(Thematic);}

}
