package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.PersonDto;
import com.dbRelation.db_relationProject.onetomany.entities.Person;
import com.dbRelation.db_relationProject.onetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody PersonDto personDto) {

        Person person = new Person();
        person.setPersonName(personDto.getPersonName());
        person.setPersonEmail(personDto.getPersonEmail());
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

}
