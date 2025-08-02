package com.test.test.Repository;

import com.test.test.Entities.Parapheur_Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ParapheurDocumentRepository extends JpaRepository<Parapheur_Document, Long> {
}
