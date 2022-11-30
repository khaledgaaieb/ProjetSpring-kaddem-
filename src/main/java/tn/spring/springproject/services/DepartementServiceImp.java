package tn.spring.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springproject.entities.Departement;
import tn.spring.springproject.entities.Option;
import tn.spring.springproject.entities.Universite;
import tn.spring.springproject.repository.DepartementRepository;
import tn.spring.springproject.repository.UniversiteRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DepartementServiceImp implements IDepartementServices{


    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;


    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }


    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(Integer idDepart) {
        departementRepository.deleteById(idDepart);
    }

    @Override
    public Departement getDepartementById(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option opt) {
        return departementRepository.retrieveDepartementByOptionEtudiant(opt);
    }

    @Override
    public  Set<Departement> retrieveDepartementByUniversite(Integer idUniversite){
        Universite uni = universiteRepository.findById(idUniversite).orElse(null);
        return uni.getDepartements();
    }
}
