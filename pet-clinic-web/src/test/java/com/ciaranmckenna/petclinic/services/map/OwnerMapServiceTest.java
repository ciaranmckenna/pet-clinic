package com.ciaranmckenna.petclinic.services.map;

import com.ciaranmckenna.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastName = "McCann";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(ownerId, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findById() {


    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(ownerId).build();
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(ownerId, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner saveOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());

    }

    @Test
    void findByLastName() {

        Owner mcann = ownerMapService.findByLastName(lastName);

        assertNotNull(mcann);
        assertEquals(ownerId, mcann.getId());
    }

    @Test
    void findByLastNameNotFound() {

        Owner mcann = ownerMapService.findByLastName("Foo");

        assertNull(mcann);
    }
}