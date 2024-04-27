package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.CustomerDto;
import com.dbRelation.db_relationProject.onetomany.dto.PersonnelDto;
import com.dbRelation.db_relationProject.onetomany.entities.Customer;
import com.dbRelation.db_relationProject.onetomany.entities.Personnel;
import com.dbRelation.db_relationProject.onetomany.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    //endpoint to get all personnel
    @GetMapping
    public ResponseEntity<Iterable<Personnel>> getAllPersonnel() {
        Iterable<Personnel> personnel = personnelRepository.findAll();
        return new ResponseEntity<>(personnel, HttpStatus.OK);
    }

    //Endpoint to get a personnel by id
    @GetMapping("{id}")
    public ResponseEntity<?> getPersonnelById(@PathVariable Long id) {
        Optional<Personnel> personnelOptional = personnelRepository.findById(id);
        if(personnelOptional.isPresent()) {
            Personnel personnel = personnelOptional.get();
            return new ResponseEntity<>(personnel, HttpStatus.OK);
        }
        return new ResponseEntity<>("Personnel doesn't exist", HttpStatus.NOT_FOUND);
    }

    //Endpoint to update a personnel
    @PutMapping("{id}")
    public ResponseEntity<?> updatePersonnel(@PathVariable Long id, @RequestBody PersonnelDto personnelDto) {
        Optional<Personnel> personnelOptional = personnelRepository.findById(id);
        if(personnelOptional.isPresent()) {
            Personnel personnel = personnelOptional.get();
            personnel.setFirstName(personnelDto.getFirstName());
            personnel.setLastName(personnelDto.getLastName());
            personnel.setBirthDate(personnelDto.getBirthDate());
            personnel.setAge(personnelDto.getAge());
            return new ResponseEntity<>(personnelRepository.save(personnel), HttpStatus.OK);
        }
        return new ResponseEntity<>("Personnel doesn't exist", HttpStatus.NOT_FOUND);
    }


}
