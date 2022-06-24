package com.ciaranmckenna.petclinic.services.springdatajpa;

import com.ciaranmckenna.petclinic.model.Visit;
import com.ciaranmckenna.petclinic.repositories.VisitRepository;
import com.ciaranmckenna.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VistSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VistSDJpaService(final VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visitSet = new HashSet<>();
        visitRepository.findAll().forEach(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);

    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
