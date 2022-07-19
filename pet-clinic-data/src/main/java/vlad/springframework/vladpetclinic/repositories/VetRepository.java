package vlad.springframework.vladpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.vladpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
