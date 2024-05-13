package com.dbRelation.db_relationProject.onetomany.repository;

import com.dbRelation.db_relationProject.onetomany.entities.ContactWithPerson;
import com.dbRelation.db_relationProject.onetomany.entities.Contact;
import com.dbRelation.db_relationProject.onetomany.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Query("select c from Contact c where c.name like %:name%")
    public List<Contact> findNameLikeV1(@Param("name") String name);

    @Query("select c from Contact c where c.name like %?1%")
    public List<Contact> findNameLikeV2(String name);

    @Query("select x from Contact x where x.name like %?1% order by x.name desc")
    public List<Contact> findNameLikeDesc(String name);

    @Query("select x from Contact x where x.id < %?1% order by x.id desc")
    public List<Contact> findId(Long id);

    @Query("select c from Contact c where c.person = :id")
    public List<Contact> findPersonContact(@Param("id") Person person);

    @Query("select new com.dbRelation.db_relationProject.onetomany.entities.ContactWithPerson(c, p) from Contact c inner join Person p on c.person = p")
    public List<ContactWithPerson> findAllContactsWithPerson();



}
