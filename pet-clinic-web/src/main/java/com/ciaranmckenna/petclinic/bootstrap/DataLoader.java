package com.ciaranmckenna.petclinic.bootstrap;

import com.ciaranmckenna.petclinic.model.Owner;
import com.ciaranmckenna.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ciaranmckenna.petclinic.services.OwnerService;
import com.ciaranmckenna.petclinic.services.VetService;

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
        owner1.setFirstName("Sean");
        owner1.setLastName("Ward");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mick");
        owner2.setLastName("McKenna");

        ownerService.save(owner2);


        System.out.printf("Load owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Barry");
        vet1.setLastName("McGee");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Shane");
        vet2.setLastName("McVeigh");

        vetService.save(vet2);

        System.out.printf("Load vets ....");
    }
}
