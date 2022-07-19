package vlad.springframework.vladpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import vlad.springframework.vladpetclinic.model.Pet;
import vlad.springframework.vladpetclinic.repositories.PetRepository;
import vlad.springframework.vladpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {
    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pet -> pets.add(pet));
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }
}
