package com.example.arbinatest.controller;

import com.example.arbinatest.entity.ElectronicDevice;
import com.example.arbinatest.service.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronicDevice")
public class ElectronicDeviceController {
    private final ElectronicDeviceService electronicDeviceService;

    @Autowired
    public ElectronicDeviceController(ElectronicDeviceService electronicDeviceService) {
        this.electronicDeviceService = electronicDeviceService;
    }

    @GetMapping("/")
    public List<ElectronicDevice> get(@RequestParam(defaultValue = "") String nameSupervisor,
                                      @RequestParam(defaultValue = "-1") Long factoryId) {
        return electronicDeviceService.getElectronicDevices(nameSupervisor, factoryId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addElectronicDevice(@RequestBody ElectronicDevice electronicDevice) {
        if (electronicDeviceService.addElectronicDevice(electronicDevice)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Entry added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while adding an entry");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteElectronicDevice(@RequestBody Long id) {
        if (electronicDeviceService.deleteElectronicDevice(id)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Entry successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("An error occurred when deleting an entry");
        }
    }
}
