package vlad.springframework.vladpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vlad.springframework.vladpetclinic.model.Owner;
import vlad.springframework.vladpetclinic.model.Vet;
import vlad.springframework.vladpetclinic.services.OwnerService;
import vlad.springframework.vladpetclinic.services.VetService;
import vlad.springframework.vladpetclinic.services.map.OwnerServiceMap;
import vlad.springframework.vladpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Vlad");
        owner1.setLastName("Nitu");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mara");
        owner2.setLastName("Popescu");
        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Cristian");
        vet1.setLastName("Urzica");


        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("George");
        vet2.setLastName("Ionescu");

        System.out.println("Loading vets...");
    }
}