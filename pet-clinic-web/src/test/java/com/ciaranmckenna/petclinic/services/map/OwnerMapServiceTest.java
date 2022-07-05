package com.ciaranmckenna.petclinic.services.map;

import com.ciaranmckenna.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long OWNER_ID = 1L;
    final String LAST_NAME = "Ward";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(OWNER_ID, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNER_ID);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findById() {


    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(OWNER_ID).build();
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(OWNER_ID, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner saveOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());

    }

    @Test
    void findByLastName() {

        Owner mcann = ownerMapService.findByLastName(LAST_NAME);

        assertNotNull(mcann);
        assertEquals(OWNER_ID, mcann.getId());
    }

    @Test
    void findByLastNameNotFound() {

        Owner mcann = ownerMapService.findByLastName("Foo");

        assertNull(mcann);
    }
}