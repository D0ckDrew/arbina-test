package com.example.arbinatest.repository;

import com.example.arbinatest.entity.ElectronicDevice;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ElectronicDeviceRepository extends ListCrudRepository<ElectronicDevice, Long>, JpaSpecificationExecutor {
    public List<ElectronicDevice> findTop5ByOrderByReleaseDateDesc();
}
