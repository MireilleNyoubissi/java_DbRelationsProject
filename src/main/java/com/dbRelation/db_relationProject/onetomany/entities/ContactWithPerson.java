package com.dbRelation.db_relationProject.onetomany.entities;

import lombok.Data;

@Data
public class ContactWithPerson {
    private Contact contact;
    private Person person;

    public ContactWithPerson(Contact contact, Person person) {
        this.contact = contact;
        this.person = person;
    }

    public ContactWithPerson() {
    }
}
