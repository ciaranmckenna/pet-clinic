package com.ciaranmckenna.petclinic.services.springdatajpa;

import com.ciaranmckenna.petclinic.model.Owner;
import com.ciaranmckenna.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner owner1;
    Owner owner2;
    private final String LAST_NAME_PERSON_A = "McKenna";
    private final String LAST_NAME_PERSON_B = "Ward";
    private final Long OWNER_ID_PERSON_A = 1L;
    private final Long OWNER_ID_PERSON_B = 2L;

    @BeforeEach
    void setUp() {
        owner1 = Owner.builder().id(OWNER_ID_PERSON_A).lastName(LAST_NAME_PERSON_A).build();
        owner2 = Owner.builder().id(OWNER_ID_PERSON_B).lastName(LAST_NAME_PERSON_B).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(owner1);
        ownerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner1));

        Owner owner = service.findById(OWNER_ID_PERSON_A);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(OWNER_ID_PERSON_A);

        assertNull(owner);
    }

    @Test
    void save() {

        when(ownerRepository.save(any())).thenReturn(owner1);

        Owner savedOwner = service.save(owner1);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(owner1);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID_PERSON_A);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner1);

        Owner mckenna = service.findByLastName(LAST_NAME_PERSON_A);

        assertEquals(LAST_NAME_PERSON_A, mckenna.getLastName());
    }

}