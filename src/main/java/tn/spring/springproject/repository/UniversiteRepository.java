package tn.spring.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springproject.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
}
