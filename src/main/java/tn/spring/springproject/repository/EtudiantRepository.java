package tn.spring.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.spring.springproject.entities.Equipe;
import tn.spring.springproject.entities.Etudiant;
import tn.spring.springproject.entities.Option;

import java.util.List;
import java.util.Set;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByPrenomEtudiant(String Prenom);


    @Query("SELECT etd FROM Etudiant etd"
            + " INNER JOIN etd.equips equipe "
            + " INNER JOIN DetailEquipe detailequip"
            + " ON detailequip.equipe = equipe.idEquipe"
            + " WHERE detailequip.thematique =:thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);

    @Modifying
    @Query("update Etudiant e set e.option = :op where e.idEtudiant =:idEtudiant")
    void updateEtudiantByOption(Option op , Long idEtudiant);

    Set<Etudiant> getEtudiantByDepartement(Integer idDepartement);
}
