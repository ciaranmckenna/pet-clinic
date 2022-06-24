package com.ciaranmckenna.petclinic.services.springdatajpa;

import com.ciaranmckenna.petclinic.model.PetType;
import com.ciaranmckenna.petclinic.repositories.PetTypeRepository;
import com.ciaranmckenna.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(final PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypeSet = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypeSet::add);
        return petTypeSet;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {

        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {

        petTypeRepository.deleteById(id);
    }
}
