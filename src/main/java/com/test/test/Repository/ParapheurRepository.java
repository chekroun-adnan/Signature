package com.test.test.Repository;

import com.test.test.Entities.Parapheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParapheurRepository extends JpaRepository<Parapheur, Long> {
}
