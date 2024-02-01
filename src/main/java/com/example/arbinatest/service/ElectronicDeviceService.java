package com.example.arbinatest.service;

import com.example.arbinatest.entity.ElectronicDevice;
import com.example.arbinatest.entity.Factory;
import com.example.arbinatest.repository.ElectronicDeviceRepository;
import com.example.arbinatest.repository.FactoryRepository;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ElectronicDeviceService {
    private final ElectronicDeviceRepository electronicDeviceRepository;
    private final FactoryRepository factoryRepository;

    @Autowired
    public ElectronicDeviceService(ElectronicDeviceRepository electronicDeviceRepository, FactoryRepository factoryRepository) {
        this.electronicDeviceRepository = electronicDeviceRepository;
        this.factoryRepository = factoryRepository;
    }

    public List<ElectronicDevice> getElectronicDevices(String nameSupervisor, Long factoryId) {

        Specification<ElectronicDevice> spec = new Specification<ElectronicDevice>() {
            @Override
            public Predicate toPredicate(Root<ElectronicDevice> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (nameSupervisor != null && !nameSupervisor.isEmpty()) {
                    predicates.add(criteriaBuilder.equal(root.get("nameSupervisor"), nameSupervisor));
                }
                if (factoryId > -1) {
                    predicates.add(criteriaBuilder.equal(root.get("factoryId"), factoryId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return electronicDeviceRepository.findAll(spec);
    }

    public boolean addElectronicDevice(ElectronicDevice electronicDevice) {
        if (electronicDevice == null || electronicDevice.factory == null || electronicDevice.factory.getId() == null) {
            return false;
        }
        Optional<Factory> factoryOptional = factoryRepository.findById(electronicDevice.factory.getId());
        if (factoryOptional.isEmpty()) {
            return false;
        }

        electronicDevice.setFactory(factoryOptional.get());
        electronicDeviceRepository.save(electronicDevice);
        return true;
    }

    public void deleteElectronicDevice(Long id) {
        electronicDeviceRepository.deleteById(id);
    }
}
