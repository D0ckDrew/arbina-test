package com.example.arbinatest.repository;

import com.example.arbinatest.entity.Factory;
import com.example.arbinatest.model.FactoryRatingModel;
import com.example.arbinatest.model.FactoryStatisticModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FactoryRepository extends ListCrudRepository<Factory, Long> {

    @Modifying
    @Query("select new com.example.arbinatest.model.FactoryRatingModel(factory.id, factory.name, count(*)) " +
            "from ElectronicDevice device " +
            "join device.factory factory " +
            "where device.releaseDate >= :startDate " +
            "group by factory.id, factory.name " +
            "order by count(*) desc limit 5")
    public List<FactoryRatingModel> getFactoriesRating(@Param("startDate") Date startDate);

    @Modifying
    @Query("select new com.example.arbinatest.model.FactoryStatisticModel(year(device.releaseDate)" +
            ", month(device.releaseDate), day(device.releaseDate), count(*)) " +
            "from ElectronicDevice device " +
            "join device.factory factory " +
            "where device.releaseDate >= :startDate " +
            "group by year(device.releaseDate), month(device.releaseDate), day(device.releaseDate) " +
            "order by year(device.releaseDate) desc, month(device.releaseDate) desc, day(device.releaseDate) desc")
    public List<FactoryStatisticModel> getFactoriesStatic(@Param("startDate") Date startDate);
}