package com.example.arbinatest.controller;

import com.example.arbinatest.entity.ElectronicDevice;
import com.example.arbinatest.service.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addElectronicDevice(@RequestBody ElectronicDevice electronicDevice) {
        electronicDeviceService.addElectronicDevice(electronicDevice);
    }

    @DeleteMapping("/delete")
    public void deleteElectronicDevice(@RequestBody Long id) {
        electronicDeviceService.deleteElectronicDevice(id);
    }
}
