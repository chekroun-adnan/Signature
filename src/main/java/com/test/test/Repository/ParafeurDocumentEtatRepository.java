package com.test.test.Repository;

import com.test.test.Entities.Parafeur_Document_Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParafeurDocumentEtatRepository extends JpaRepository<Parafeur_Document_Etat, Long> {
}
