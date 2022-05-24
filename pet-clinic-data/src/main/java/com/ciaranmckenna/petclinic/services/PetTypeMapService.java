package com.ciaranmckenna.petclinic.services;

import com.ciaranmckenna.petclinic.model.PetType;
import com.ciaranmckenna.petclinic.services.map.AbstractMapService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {


}
