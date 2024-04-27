package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.PersonnelDto;
import com.dbRelation.db_relationProject.onetomany.entities.Personnel;
import com.dbRelation.db_relationProject.onetomany.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/personnel")
public class PersonnelController {

    @Autowired
    PersonnelRepository personnelRepository;

    //Endpoints to create a personnel
    @PostMapping
    public ResponseEntity<Personnel> createPersonnel(@RequestBody PersonnelDto personnelDto) {
        Personnel personnel = new Personnel();
        personnel.setFirstName(personnelDto.getFirstName());
        personnel.setLastName(personnelDto.getLastName());
        personnel.setBirthDate(personnelDto.getBirthDate());
        personnel.setAge(personnelDto.getAge());
        return new ResponseEntity<>(personnelRepository.save(personnel), HttpStatus.CREATED);
    }


}
