package tn.spring.springproject.services;

import tn.spring.springproject.entities.Contrat;
import tn.spring.springproject.entities.Etudiant;


import java.util.Date;
import java.util.List;

public interface IContratServices {
    List<Contrat> getALLContrat();
    Contrat addContrat(Contrat c);
    Contrat updateContrat(Contrat c);
    void deleteContrat(Integer id);
    Contrat getContratById(Integer id);

    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

     float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    public Integer nbContratsValides(Date startDate, Date endDate) ;

    public String retrieveAndUpdateStatusContrat();


}
