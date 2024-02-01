package com.example.arbinatest.controller;

import com.example.arbinatest.entity.Factory;
import com.example.arbinatest.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addElectronicDevice(@RequestBody Factory factory) {
        factoryService.addFactory(factory);
    }

    @DeleteMapping("/delete")
    public void deleteElectronicDevice(@RequestBody Long id) {
        factoryService.deleteFactory(id);
    }
}
