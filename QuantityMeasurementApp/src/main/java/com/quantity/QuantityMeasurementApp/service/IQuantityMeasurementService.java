package com.quantity.QuantityMeasurementApp.service;

import com.quantity.QuantityMeasurementApp.dto.QuantityDTO;

public interface IQuantityMeasurementService {

    boolean compare(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO convert(QuantityDTO q, Enum<?> targetUnit);
}