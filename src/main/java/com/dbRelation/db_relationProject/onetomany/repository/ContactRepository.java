package com.dbRelation.db_relationProject.onetomany.repository;

import com.dbRelation.db_relationProject.onetomany.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Query("select c from Contact c where c.name like %:name%")
    public List<Contact> findNameLikeV1(@Param("name") String name);

    @Query("select c from Contact c where c.name like %?1%")
    public List<Contact> findNameLikeV2(String name);
}
