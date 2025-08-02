package com.test.test.Repository;

import com.test.test.Entities.Type_Parapheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeParapheurRepository extends JpaRepository<Type_Parapheur, Long> {
}
