package tn.spring.springproject.services;

import org.springframework.stereotype.Service;
import tn.spring.springproject.entities.Departement;
import tn.spring.springproject.entities.Option;

import java.util.List;
import java.util.Set;

public interface IDepartementServices {

    List<Departement> getAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    void deleteDepartement (Integer idDepart);

    Departement getDepartementById(Integer idDepart);

    List<Departement> retrieveDepartementByOptionEtudiant(Option op);

     Set<Departement> retrieveDepartementByUniversite(Integer idUniversite);



}
