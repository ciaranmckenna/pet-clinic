package com.ciaranmckenna.petclinic.repositories;

import com.ciaranmckenna.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
