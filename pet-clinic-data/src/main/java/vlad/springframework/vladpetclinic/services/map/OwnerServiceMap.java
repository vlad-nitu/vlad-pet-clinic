package vlad.springframework.vladpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import vlad.springframework.vladpetclinic.model.Owner;
import vlad.springframework.vladpetclinic.model.Pet;
import vlad.springframework.vladpetclinic.services.OwnerService;
import vlad.springframework.vladpetclinic.services.PetService;
import vlad.springframework.vladpetclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner == null)
            return null;

        if (owner.getPets() != null)
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else throw new RuntimeException("Pet type is required.");

                if (pet.getId() == null){
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        return super.save(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
       return this.findAll()
               .stream()
               .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
               .findFirst().orElse(null);
    }
}
