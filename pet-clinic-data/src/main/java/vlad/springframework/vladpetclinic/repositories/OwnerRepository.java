package vlad.springframework.vladpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.vladpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
