package com.ciaranmckenna.petclinic.repositories;

import com.ciaranmckenna.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(@Param("lastName") String lastName);
}
