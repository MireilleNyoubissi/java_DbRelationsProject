package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.HouseDto;
import com.dbRelation.db_relationProject.onetomany.entities.House;
import com.dbRelation.db_relationProject.onetomany.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/houses")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody HouseDto houseDto) {
        House house = new House();
        house.setAddress(houseDto.getAddress());
        return new ResponseEntity<>(houseRepository.save(house), HttpStatus.CREATED);
    }
}
