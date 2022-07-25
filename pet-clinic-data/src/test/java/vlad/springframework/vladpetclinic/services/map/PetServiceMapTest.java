package vlad.springframework.vladpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vlad.springframework.vladpetclinic.model.Pet;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PetServiceMapTest {
    private PetServiceMap petServiceMap;
    private final Long petId1 = 1L;
    private final Long petId2 = 2L;
    private Pet pet1, pet2;
    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        pet1 = Pet.builder().id(petId1).build();
        pet2 = Pet.builder().id(petId2).build();
        petServiceMap.save(pet1);
        petServiceMap.save(pet2);
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();
        assertThat(pets).hasSize(2);
        assertThat(pets).contains(pet1, pet2);
    }

    @Test
    void findById() {
        assertThat(petServiceMap.findById(petId1)).isEqualTo(pet1);
    }

    @Test
    void saveNewPet() {
        Pet pet3 = Pet.builder().id(3L).build();
        assertThat(petServiceMap.save(pet3)).isEqualTo(pet3);
    }
    @Test
    void saveNullPet() {
        Pet pet3 = null;
        assertThatThrownBy(() -> petServiceMap.save(pet3))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("cannot be null.");
    }

    @Test
    void delete() {
        petServiceMap.delete(pet1);
        Set<Pet> pets = petServiceMap.findAll();
        assertThat(pets).hasSize(1);
        assertThat(pets).contains(pet2);
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(petId1);
        Set<Pet> pets = petServiceMap.findAll();
        assertThat(pets).hasSize(1);
        assertThat(pets).contains(pet2);

    }
}