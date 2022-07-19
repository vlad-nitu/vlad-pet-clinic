package vlad.springframework.vladpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.vladpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
