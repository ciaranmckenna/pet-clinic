package com.ciaranmckenna.petclinic.repositories;

import com.ciaranmckenna.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
