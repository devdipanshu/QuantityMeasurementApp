package com.quantity.QuantityMeasurementApp;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double toFeet() {
        return unit.toFeet(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;

        return Math.abs(this.toFeet() - other.toFeet()) < 0.0001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toFeet());
    }
}

