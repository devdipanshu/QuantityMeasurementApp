package com.quantity.QuantityMeasurementApp.controller;

import com.quantity.QuantityMeasurementApp.dto.QuantityDTO;
import com.quantity.QuantityMeasurementApp.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return service.compare(q1, q2);
    }

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        return service.add(q1, q2);
    }

    public QuantityDTO convert(QuantityDTO q, Enum<?> unit) {
        return service.convert(q, unit);
    }
}