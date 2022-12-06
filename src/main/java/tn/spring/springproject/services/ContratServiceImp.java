package tn.spring.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springproject.entities.Contrat;
import tn.spring.springproject.entities.Etudiant;
import tn.spring.springproject.repository.ContratRepository;
import tn.spring.springproject.repository.EtudiantRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImp implements IContratServices{


    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;
    @Override
    public List<Contrat> getALLContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(Integer id) {
        contratRepository.deleteById(id);

    }

    @Override
    public Contrat getContratById(Integer id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {

        Etudiant etudiant = etudiantRepository.findEtudiantByPrenomEtudiant(prenomE);
        if(etudiant.getContrats().size()<5){
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
        }else System.out.println("cannot add new contrat to etudiant");
        return ce;
    }


   @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float CA=0;
        int nbOfMonths=1;

        List< Contrat> contrat= contratRepository.findAll();
        for(int i=0;i<contrat.size();i++){
            Contrat ct=contrat.get(i);
            int dd=Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
            int df=Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));

            if((nbOfMonths*=(df-dd))==0){
                nbOfMonths=1;
            }else{
                nbOfMonths=(df-dd);
            }
            if(ct.isArchive()==false){

                System.out.println("*******"+nbOfMonths);

                if(ct.getSpecialite().toString()=="IA"){
                    CA+=nbOfMonths*300;

                }
                else if(ct.getSpecialite().toString()=="RESEAUX"){
                    CA+=nbOfMonths*350;
                }
                else if(ct.getSpecialite().toString()=="CLOUD"){
                    CA+=nbOfMonths*400;
                }
                else if(ct.getSpecialite().toString()=="SECURITE"){
                    CA+=nbOfMonths*450;
                }

            }

        }
        return CA;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        int j=0 ;

        List< Contrat> contrat= contratRepository.findAll();

        for(int i=0;i<contrat.size();i++){
            Contrat ct=contrat.get(i);

            if(ct.isArchive()==false){
                j++;
                System.out.println( j+" contrat disponible");

            }

        }
        return j;
    }

    @Scheduled(cron = "* * 13 * * *" )
    @Override
    public String retrieveAndUpdateStatusContrat() {

        LocalDate currentDate = LocalDate.now().plusDays(15);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dayAfter15 = currentDate.format(formatter);

        System.out.println(dayAfter15);

        List<Contrat> AllContrat = contratRepository.findAll();
        AllContrat.forEach(contrat -> {
            if (contrat.getDateFinContrat().toString().equals(dayAfter15)) {
                System.out.println("le Contrat ayant l id : "+ contrat.getIdContrat()+ " du specialite " +
                                contrat.getSpecialite()+" affecté à l'etudiant "
                        +contrat.getEtudiant()+" se termine dans 15 jours !!" ) ;
                contrat.setArchive(true);
                contratRepository.save(contrat);

            }
        });
        return "check console" ;
    }


}
