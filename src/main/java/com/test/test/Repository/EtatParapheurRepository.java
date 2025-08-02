package com.test.test.Repository;

import com.test.test.Entities.Etat_Parapheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatParapheurRepository extends JpaRepository<Etat_Parapheur, Long> {

}
