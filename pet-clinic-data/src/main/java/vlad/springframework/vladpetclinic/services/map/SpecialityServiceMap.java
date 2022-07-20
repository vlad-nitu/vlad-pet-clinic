package vlad.springframework.vladpetclinic.services.map;

import org.springframework.stereotype.Service;
import vlad.springframework.vladpetclinic.model.Speciality;
import vlad.springframework.vladpetclinic.services.SpecialityService;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }
}
