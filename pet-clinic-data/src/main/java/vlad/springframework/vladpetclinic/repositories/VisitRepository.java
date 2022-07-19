package vlad.springframework.vladpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.vladpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
