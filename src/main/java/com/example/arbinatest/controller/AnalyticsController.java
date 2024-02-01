package com.example.arbinatest.controller;

import com.example.arbinatest.entity.ElectronicDevice;
import com.example.arbinatest.model.FactoryRatingModel;
import com.example.arbinatest.model.FactoryStatisticModel;
import com.example.arbinatest.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    private final AnalyticsService analyticsService;

    @Autowired
    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/factoryTop")
    public List<FactoryRatingModel> getFactoryTop() {
        return analyticsService.getFactoryTop();
    }

    @GetMapping("/lastElectronicDevices")
    public List<ElectronicDevice> getLastElectronicDevices() {
        return analyticsService.getLastElectronicDevices();
    }

    @GetMapping("/dailyStatistics")
    public List<FactoryStatisticModel> getDailyStatistics() {
        return analyticsService.getDailyStatistic();
    }
}
