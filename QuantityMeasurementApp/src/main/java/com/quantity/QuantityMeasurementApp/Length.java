package com.quantity.QuantityMeasurementApp;

import java.util.Objects;

public class Length {

    private final int value;
    private final LengthUnit unit;

    public Length(int value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public int toInch() {
        return unit.toInch(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;
        return this.toInch() == other.toInch();
    }

    @Override
    public int hashCode() {
        return Objects.hash(toInch());
    }
}
