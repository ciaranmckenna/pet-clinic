package com.ciaranmckenna.petclinic.services.map;

import com.ciaranmckenna.petclinic.model.Visit;
import com.ciaranmckenna.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit, must have at least some data");
        } else if ((visit.getPet() == null) || (visit.getPet().getOwner() == null) || (visit.getPet().getId() == null)) {
            throw new RuntimeException("Invalid visit, must have at least some data");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
