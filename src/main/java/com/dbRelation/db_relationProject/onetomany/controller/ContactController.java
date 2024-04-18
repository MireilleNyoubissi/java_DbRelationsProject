package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.AddPersonToContact;
import com.dbRelation.db_relationProject.onetomany.dto.ContactDto;
import com.dbRelation.db_relationProject.onetomany.entities.Contact;
import com.dbRelation.db_relationProject.onetomany.entities.Person;
import com.dbRelation.db_relationProject.onetomany.repository.ContactRepository;
import com.dbRelation.db_relationProject.onetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        contact.setEmail(contactDto.getEmail());
        return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.CREATED);
    }

    //Endpoint to update person in contact

    @PostMapping("{personId}")
    public ResponseEntity<?> updatePersonInContact(@PathVariable Long personId, @RequestBody AddPersonToContact addPersonToContact) {
        Optional<Person> personOptional = personRepository.findById(personId);
        if(personOptional.isPresent()) {
            Person person = personOptional.get();
            if(addPersonToContact.getContactId() != null) {
                Optional<Contact> contactOptional = contactRepository.findById(addPersonToContact.getContactId());
                if(contactOptional.isPresent()) {
                    Contact contact = contactOptional.get();
                    contact.setPerson(person);
                    return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("Contact doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Person doesn't exist", HttpStatus.NOT_FOUND);
    }
}
