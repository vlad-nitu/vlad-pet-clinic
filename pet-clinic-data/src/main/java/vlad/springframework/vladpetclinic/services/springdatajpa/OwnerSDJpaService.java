package vlad.springframework.vladpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import vlad.springframework.vladpetclinic.model.Owner;
import vlad.springframework.vladpetclinic.repositories.OwnerRepository;
import vlad.springframework.vladpetclinic.repositories.PetRepository;
import vlad.springframework.vladpetclinic.repositories.PetTypeRepository;
import vlad.springframework.vladpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner -> owners.add(owner));
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        return ownerOptional.orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
