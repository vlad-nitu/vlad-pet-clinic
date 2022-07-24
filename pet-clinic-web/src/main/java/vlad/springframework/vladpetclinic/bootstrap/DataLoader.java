package vlad.springframework.vladpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vlad.springframework.vladpetclinic.model.*;
import vlad.springframework.vladpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Vlad");
        owner1.setLastName("Nitu");
        owner1.setAddress("Ion Maiorescu");
        owner1.setCity("Ploiesti");
        owner1.setTelephone("0747123123");

        Pet vladsPet = new Pet();
        vladsPet.setPetType(savedDogPetType);
        vladsPet.setOwner(owner1);
        vladsPet.setBirthDate(LocalDate.now());
        vladsPet.setName("Ralph");
        owner1.getPets().add(vladsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mara");
        owner2.setLastName("Popescu");
        owner2.setAddress("Mediurg");
        owner2.setCity("Ploiesti");
        owner2.setTelephone("0747567567");

        Pet marasCat = new Pet();
        marasCat.setPetType(savedCatPetType);
        marasCat.setOwner(owner2);
        marasCat.setBirthDate(LocalDate.now());
        marasCat.setName("Fifi");
        owner2.getPets().add(marasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(marasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy cat");

        visitService.save(catVisit);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Cristian");
        vet1.setLastName("Urzica");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("George");
        vet2.setLastName("Ionescu");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
