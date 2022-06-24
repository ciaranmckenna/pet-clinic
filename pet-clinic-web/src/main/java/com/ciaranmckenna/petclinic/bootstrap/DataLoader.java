package com.ciaranmckenna.petclinic.bootstrap;

import com.ciaranmckenna.petclinic.model.*;
import com.ciaranmckenna.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType horse = new PetType();
        horse.setName("Horse");
        PetType savedHorsePetType = petTypeService.save(horse);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sean");
        owner1.setLastName("Ward");
        owner1.setAddress("2 Moy Road");
        owner1.setTelephone("9874645");

        Pet seansPet = new Pet();
        seansPet.setPetType(savedDogPetType);
        seansPet.setOwner(owner1);
        seansPet.setBirthDate(LocalDate.now());
        seansPet.setName("Flan");
        owner1.getPets().add(seansPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mick");
        owner2.setLastName("McKenna");
        owner2.setAddress("16 Desert Lane");
        owner2.setTelephone("123654");

        Pet micksPet = new Pet();
        micksPet.setPetType(savedHorsePetType);
        micksPet.setOwner(owner2);
        micksPet.setBirthDate(LocalDate.now());
        micksPet.setName("Tyson");
        owner2.getPets().add(micksPet);

        ownerService.save(owner2);

        Visit micksPetVisit = new Visit();
        micksPetVisit.setPet(micksPet);
        micksPetVisit.setDate(LocalDate.now());
        micksPetVisit.setDescription("Big horse");

        visitService.save(micksPetVisit);

        System.out.printf("Load owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Barry");
        vet1.setLastName("McGee");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Shane");
        vet2.setLastName("McVeigh");
        vet2.getSpecialities().add(saveDentistry);

        vetService.save(vet2);

        System.out.printf("Load vets ....");
    }
}
