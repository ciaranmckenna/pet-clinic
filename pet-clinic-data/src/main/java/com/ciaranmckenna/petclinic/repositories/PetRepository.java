package com.ciaranmckenna.petclinic.repositories;

import com.ciaranmckenna.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
