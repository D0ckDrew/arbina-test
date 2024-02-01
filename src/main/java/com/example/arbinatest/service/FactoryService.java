package com.example.arbinatest.service;

import com.example.arbinatest.entity.Factory;
import com.example.arbinatest.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryService {
    private final FactoryRepository factoryRepository;

    @Autowired
    public FactoryService(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    public List<Factory> getAllFactories() {
        return factoryRepository.findAll();
    }

    public void addFactory(Factory factory) {
        factoryRepository.save(factory);
    }

    public void deleteFactory(Long factoryId) {
        factoryRepository.deleteById(factoryId);
    }
}
