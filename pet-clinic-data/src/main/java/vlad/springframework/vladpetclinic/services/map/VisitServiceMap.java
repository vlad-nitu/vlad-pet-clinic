package vlad.springframework.vladpetclinic.services.map;

import vlad.springframework.vladpetclinic.model.Visit;
import vlad.springframework.vladpetclinic.repositories.VisitRepository;

import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceMap(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null
                || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid visit");
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
