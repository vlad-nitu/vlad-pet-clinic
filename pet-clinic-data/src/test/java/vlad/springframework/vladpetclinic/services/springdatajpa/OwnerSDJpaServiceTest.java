package vlad.springframework.vladpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vlad.springframework.vladpetclinic.model.Owner;
import vlad.springframework.vladpetclinic.repositories.OwnerRepository;
import vlad.springframework.vladpetclinic.repositories.PetRepository;
import vlad.springframework.vladpetclinic.repositories.PetTypeRepository;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "John";
    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;
    private OwnerSDJpaService service;

    private Owner returnOwner;

    @BeforeEach
    void setUp() {
        service = new OwnerSDJpaService(ownerRepository, petRepository, petTypeRepository);
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = Set.of(
                Owner.builder().id(1L).build(),
                Owner.builder().id(2L).build());
        when(service.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> ownerSet = service.findAll();
        assertNotNull(ownerSet);
        assertThat(ownerSet).hasSize(2);

    }

    @Test
    void findById() {
        when(ownerRepository.findById(any(Long.class))).thenReturn(Optional.of(returnOwner));
        Owner owner =   service.findById(1L);
        assertThat(owner).isNotNull();
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        Owner owner =   service.findById(1L);
        assertThat(owner).isNull();
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(2L).lastName("Vlad").build();
        when(ownerRepository.save(ownerToSave)).thenReturn(ownerToSave);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        assertThat(savedOwner).isEqualTo(ownerToSave);
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any(Owner.class));
        assertThat(service.findAll()).isEmpty();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnOwner);
        Owner john = service.findByLastName(LAST_NAME); // call MUT
        assertThat(LAST_NAME).isEqualTo(john.getLastName());
        verify(ownerRepository).findByLastName(any(String.class));
    }
}