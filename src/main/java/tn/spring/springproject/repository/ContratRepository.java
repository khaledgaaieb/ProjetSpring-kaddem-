package tn.spring.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springproject.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {



}
