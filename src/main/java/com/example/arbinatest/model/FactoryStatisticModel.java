package com.example.arbinatest.model;

import java.time.LocalDate;

public class FactoryStatisticModel {
    private LocalDate date;
    private Long count;

    public FactoryStatisticModel(int year, int month, int day, Long count) {
        this.date = LocalDate.of(year,month,day);
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
