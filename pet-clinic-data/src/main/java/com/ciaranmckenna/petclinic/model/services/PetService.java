package com.ciaranmckenna.petclinic.model.services;

import com.ciaranmckenna.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save (Pet pet);

    Set<Pet> findAll();
}
