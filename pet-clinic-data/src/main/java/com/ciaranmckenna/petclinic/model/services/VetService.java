package com.ciaranmckenna.petclinic.model.services;

import com.ciaranmckenna.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save (Vet vet);

    Set<Vet> findAll();
}
