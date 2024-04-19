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

import java.util.List;
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

    // this endpoint get all contacts
    @GetMapping
    public ResponseEntity<Iterable<Contact>> getAllContacts(){
        Iterable<Contact> contacts = contactRepository.findAll();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    //This endpoint get a contact by its id
    @GetMapping("{id}")
    public ResponseEntity<?> getContactById(@PathVariable Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
        return new ResponseEntity<>("Contact not find", HttpStatus.NOT_FOUND);
    }

    //This endpoint update a contact
    @PutMapping("{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @RequestBody ContactDto contactDto) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setName(contactDto.getName());
            contact.setTel(contactDto.getTel());
            contact.setEmail(contactDto.getEmail());
            return new ResponseEntity<>(contactRepository.save(contact), HttpStatus.OK);
        }
        return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
    }

    //This endpoint delete a contact
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contactRepository.delete(contact);
            return new ResponseEntity<>("Contact has been deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("contact not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("searchName")
    public ResponseEntity<List<Contact>> findNameLike(@RequestParam String searchName) {
        return new ResponseEntity<>(contactRepository.findNameLikeV2(searchName), HttpStatus.OK);
    }

}
