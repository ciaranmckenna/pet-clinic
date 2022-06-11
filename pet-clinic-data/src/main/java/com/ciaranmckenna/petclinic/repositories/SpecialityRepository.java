package com.ciaranmckenna.petclinic.repositories;

import com.ciaranmckenna.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
