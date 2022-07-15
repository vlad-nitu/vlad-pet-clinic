package vlad.springframework.vladpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vlad.springframework.vladpetclinic.model.Owner;
import vlad.springframework.vladpetclinic.model.Vet;
import vlad.springframework.vladpetclinic.services.OwnerService;
import vlad.springframework.vladpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Vlad");
        owner1.setLastName("Nitu");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mara");
        owner2.setLastName("Popescu");
        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Cristian");
        vet1.setLastName("Urzica");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("George");
        vet2.setLastName("Ionescu");
        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
