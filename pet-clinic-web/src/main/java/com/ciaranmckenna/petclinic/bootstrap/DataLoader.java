package com.ciaranmckenna.petclinic.bootstrap;

import com.ciaranmckenna.petclinic.model.Owner;
import com.ciaranmckenna.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Sean");
        owner1.setLastName("Ward");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mick");
        owner2.setLastName("McKenna");
        owner2.setId(2L);

        ownerService.save(owner2);


        System.out.printf("Load owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Barry");
        vet1.setLastName("McGee");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Shane");
        vet2.setLastName("McVeigh");
        vet2.setId(2L);

        vetService.save(vet2);

        System.out.printf("Load vets ....");
    }
}
