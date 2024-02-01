package com.example.arbinatest.controller;

import com.example.arbinatest.entity.Factory;
import com.example.arbinatest.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factory")
public class FactoryController {
    private final FactoryService factoryService;

    @Autowired
    public FactoryController(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    @GetMapping("/")
    public List<Factory> get() {
        return factoryService.getAllFactories();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addElectronicDevice(@RequestBody Factory factory) {
        if (factoryService.addFactory(factory)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Entry added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while adding an entry");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteElectronicDevice(@RequestBody Long id) {
        if (factoryService.deleteFactory(id)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Entry successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("An error occurred when deleting an entry");
        }
    }
}
