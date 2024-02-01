package com.example.arbinatest.service;

import com.example.arbinatest.entity.ElectronicDevice;
import com.example.arbinatest.model.FactoryRatingModel;
import com.example.arbinatest.model.FactoryStatisticModel;
import com.example.arbinatest.repository.ElectronicDeviceRepository;
import com.example.arbinatest.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AnalyticsService {
    private final FactoryRepository factoryRepository;
    private final ElectronicDeviceRepository electronicDeviceRepository;

    @Autowired
    public AnalyticsService(FactoryRepository factoryRepository,
                            ElectronicDeviceRepository electronicDeviceRepository) {
        this.factoryRepository = factoryRepository;
        this.electronicDeviceRepository = electronicDeviceRepository;
    }

    public List<FactoryRatingModel> getFactoryTop() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        return factoryRepository.getFactoriesRating(cal.getTime());
    }

    public List<ElectronicDevice> getLastElectronicDevices() {
        return electronicDeviceRepository.findTop5ByOrderByReleaseDateDesc();
    }

    public List<FactoryStatisticModel> getDailyStatistic() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        return factoryRepository.getFactoriesStatic(cal.getTime());
    }
}
