package com.dbRelation.db_relationProject.onetomany.controller;

import com.dbRelation.db_relationProject.onetomany.dto.SupplierDto;
import com.dbRelation.db_relationProject.onetomany.entities.Supplier;
import com.dbRelation.db_relationProject.onetomany.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;

    //Endpoint to create a supplier

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody SupplierDto supplierDto) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierDto.getSupplierName());
        supplier.setContactName(supplierDto.getContactName());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setPostalCode(supplierDto.getPostalCode());
        supplier.setCity(supplierDto.getCity());
        supplier.setCountry(supplierDto.getCountry());
        return new ResponseEntity<>(supplierRepository.save(supplier), HttpStatus.CREATED);
    }

}
