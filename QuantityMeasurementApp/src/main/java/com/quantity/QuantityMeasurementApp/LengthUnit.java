package com.quantity.QuantityMeasurementApp;


public enum LengthUnit {
    FEET(12),
    INCH(1);

    private final int value;

    LengthUnit(int value) {
        this.value = value;
    }

    public int toInch(int amount) {
        return amount * value;
    }
}
