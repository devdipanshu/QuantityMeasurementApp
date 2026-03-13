package com.quantity.QuantityMeasurementApp.service;

import com.quantity.QuantityMeasurementApp.dto.QuantityDTO;
import com.quantity.QuantityMeasurementApp.entity.QuantityMeasurementEntity;
import com.quantity.QuantityMeasurementApp.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return q1.getValue() == q2.getValue();
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        double result = q1.getValue() + q2.getValue();

        repository.save(
                new QuantityMeasurementEntity(
                        q1.getValue(),
                        q2.getValue(),
                        result,
                        "ADD"
                )
        );

        return new QuantityDTO(result, q1.getUnit());
    }

    @Override
    public QuantityDTO convert(QuantityDTO q, Enum<?> unit) {
        return new QuantityDTO(q.getValue(), unit);
    }
}