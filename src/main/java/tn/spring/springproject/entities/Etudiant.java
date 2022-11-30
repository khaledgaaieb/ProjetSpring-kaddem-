package tn.spring.springproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "etudiant")
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idEtudiant;
     String prenomEtudiant;
     String nomEtudiant;
    @Enumerated(EnumType.STRING)
     Option option;


    @ManyToOne
    @JsonIgnore
     Departement departement;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "etudiant")
     Set<Contrat> contrats;

    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.PERSIST)
     Set<Equipe> equips;


}
