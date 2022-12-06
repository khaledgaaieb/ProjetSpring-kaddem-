package tn.spring.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springproject.entities.Contrat;
import tn.spring.springproject.entities.Equipe;
import tn.spring.springproject.entities.Etudiant;
import tn.spring.springproject.entities.Niveau;
import tn.spring.springproject.repository.ContratRepository;
import tn.spring.springproject.repository.EquipeRepository;
import tn.spring.springproject.repository.EtudiantRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EquipeServiceImp implements IEquipeServices{


    EquipeRepository equipeRepository;
    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long id) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(id);
    }
    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant){
        return equipeRepository.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement (Long idEtudiant, Integer idDepart){
        return equipeRepository.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(idEtudiant,idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique){
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }

    @Override
    public void deleteEquipeByNiveau( Niveau niveau){
        equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Scheduled(cron = "* * * * * *" )
    @Override
    public void faireEvoluerEquipes() {
        List<Equipe> allEquips = equipeRepository.findAll();
        allEquips.forEach(equipe -> {
            Set<Etudiant> etudEquip =  equipe.getEtudiants();
            if(etudEquip.size()>=3){
                etudEquip.forEach(etudiant -> {
                   Set<Contrat> allContrat = etudiant.getContrats();
                   allContrat.forEach(contrat -> {
                       int dd=Integer.parseInt(contrat.getDateDebutContrat().toString().substring(0,4));
                       int df=Integer.parseInt(contrat.getDateFinContrat().toString().substring(0,4));
                       System.out.println(df);
                       System.out.println(dd);
                       if(df-dd>=1){
                           if(equipe.getNiveau().equals("JUNIOR")){
                               System.out.println(equipe.getNiveau());
                               equipe.setNiveau(Niveau.SENIOR);
                               equipeRepository.save(equipe);
                               System.out.println(equipe.getNiveau());
                           }else if (equipe.getNiveau().equals("SENIOR")){
                               System.out.println(equipe.getNiveau());
                               equipe.setNiveau(Niveau.EXPERT);
                               equipeRepository.save(equipe);
                           }
                       }
                   });
                });
            }


        });
    }
}
