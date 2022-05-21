package com.ciaranmckenna.petclinic.services;

import com.ciaranmckenna.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
