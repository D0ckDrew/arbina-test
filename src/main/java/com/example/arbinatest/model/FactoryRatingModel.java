package com.example.arbinatest.model;

public class FactoryRatingModel {
    private Long factoryId;
    private String factoryName;
    private Long count;

    public FactoryRatingModel(Long factoryId, String factoryName, Long count) {
        this.factoryId = factoryId;
        this.factoryName = factoryName;
        this.count = count;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
