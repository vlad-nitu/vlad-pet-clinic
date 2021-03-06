package vlad.springframework.vladpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import vlad.springframework.vladpetclinic.model.Pet;
import vlad.springframework.vladpetclinic.services.PetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }
}
