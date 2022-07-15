package vlad.springframework.vladpetclinic.services.map;

import vlad.springframework.vladpetclinic.model.Vet;
import vlad.springframework.vladpetclinic.services.CrudService;
import vlad.springframework.vladpetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }
}
