package vlad.springframework.vladpetclinic.services.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vlad.springframework.vladpetclinic.model.Owner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    private OwnerServiceMap ownerServiceMap;
    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(new Owner().builder()
                .id(1L).lastName("John")
                .build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertThat(ownerSet).hasSize(1);
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertThat(owner.getId()).isEqualTo(1L);
    }

    @Test
    void saveExistingId() {
        Owner owner2 = new Owner().builder().id(2L).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertThat(owner2.getId()).isEqualTo(savedOwner.getId());
    }
    @Test
    void saveNoId(){

        Owner owner2 = new Owner().builder().build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertThat(savedOwner).isNotNull();
        assertThat(savedOwner.getId()).isNotNull();
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertThat(ownerServiceMap.findAll()).isEmpty();
    }

    @Test
    void delete() {
       ownerServiceMap.delete(ownerServiceMap.findById(1L));
       assertThat(ownerServiceMap.findAll()).isEmpty();
    }

    @Test
    void findByLastName() {
        ownerServiceMap.findById(1L).setLastName("Vlad");
        Owner vlad = ownerServiceMap.findByLastName("Vlad");
        assertNotNull(vlad);
        assertThat(vlad.getId()).isEqualTo(1L);
    }
    @Test
    void findByLastNameNotFound() {
        Owner owner2 = ownerServiceMap.findByLastName("not_found");
        assertNull(owner2);
    }
}