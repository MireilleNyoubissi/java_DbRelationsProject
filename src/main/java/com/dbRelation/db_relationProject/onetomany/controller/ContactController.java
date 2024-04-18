package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.ContactDto;
import com.dbRelation.db_relationProject.onetomany.entities.Contact;
import com.dbRelation.db_relationProject.onetomany.repository.ContactRepository;
import com.dbRelation.db_relationProject.onetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PersonRepository personRepository;

    //Endpoint to create contacts
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setTel(contactDto.getTel());
        contact.setEmail(contact.getEmail());
        return new ResponseEntity<Contact>(contactRepository.save(contact), HttpStatus.CREATED);
    }
}
