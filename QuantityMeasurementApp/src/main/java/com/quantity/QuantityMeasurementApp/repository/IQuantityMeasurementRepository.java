package com.quantity.QuantityMeasurementApp.repository;

import com.quantity.QuantityMeasurementApp.entity.QuantityMeasurementEntity;

import java.util.List;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();
}