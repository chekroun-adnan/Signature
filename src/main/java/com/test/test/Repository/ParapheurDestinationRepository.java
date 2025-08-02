package com.test.test.Repository;

import com.test.test.Entities.Parapheur_Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParapheurDestinationRepository extends JpaRepository<Parapheur_Destination, Long> {
    List<Parapheur_Destination> findBySent(boolean sent);
}
