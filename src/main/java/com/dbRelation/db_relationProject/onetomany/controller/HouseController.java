package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.AddPersonToHouseDto;
import com.dbRelation.db_relationProject.onetomany.dto.HouseDto;
import com.dbRelation.db_relationProject.onetomany.entities.House;
import com.dbRelation.db_relationProject.onetomany.entities.Person;
import com.dbRelation.db_relationProject.onetomany.repository.HouseRepository;
import com.dbRelation.db_relationProject.onetomany.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/houses")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody HouseDto houseDto) {
        House house = new House();
        house.setAddress(houseDto.getAddress());
        return new ResponseEntity<>(houseRepository.save(house), HttpStatus.CREATED);
    }

    @PostMapping("{personId}")
    public ResponseEntity<?> addPersonToHouse(@PathVariable Long personId, @RequestBody AddPersonToHouseDto addPersonToHouseDto) {

        Optional<Person> optionalPerson = personRepository.findById(personId);
        if(optionalPerson.isPresent()) {
            Person person = optionalPerson.get();

            if(addPersonToHouseDto.getHouseId() != null) {
                Optional<House> optionalHouse = houseRepository.findById(addPersonToHouseDto.getHouseId());
                if(optionalHouse.isPresent()) {
                    House house = optionalHouse.get();
                    house.setPerson(person);

                    return new ResponseEntity<>(houseRepository.save(house), HttpStatus.OK);
                }
                return new ResponseEntity<>("House not found", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("{houseId}")
    public ResponseEntity updateHouse(@PathVariable Long houseId, @RequestBody HouseDto houseDto) {
        Optional<House> optionalHouse = houseRepository.findById(houseId);
        if(optionalHouse.isPresent()) {
            House house = optionalHouse.get();
            house.setAddress(houseDto.getAddress());
            return new ResponseEntity<>(houseRepository.save(house), HttpStatus.OK);
        }
        return new ResponseEntity<>("House not found", HttpStatus.NOT_FOUND);
    }

}
