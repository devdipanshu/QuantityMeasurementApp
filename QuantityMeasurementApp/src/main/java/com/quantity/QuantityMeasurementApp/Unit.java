package com.quantity.QuantityMeasurementApp;

public interface Unit {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);
}