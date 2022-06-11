package com.ciaranmckenna.petclinic.repositories;

import com.ciaranmckenna.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
