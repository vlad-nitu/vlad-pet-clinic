package vlad.springframework.vladpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.vladpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
