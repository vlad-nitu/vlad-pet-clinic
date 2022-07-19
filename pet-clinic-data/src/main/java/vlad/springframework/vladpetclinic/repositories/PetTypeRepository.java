package vlad.springframework.vladpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.vladpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
