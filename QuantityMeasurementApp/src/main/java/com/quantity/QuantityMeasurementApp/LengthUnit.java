package com.quantity.QuantityMeasurementApp;

public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(0.0328084);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // convert this unit → base unit (feet)
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // convert base unit (feet) → this unit
    public double convertFromBaseUnit(double feet) {
        return feet / conversionFactor;
    }
}