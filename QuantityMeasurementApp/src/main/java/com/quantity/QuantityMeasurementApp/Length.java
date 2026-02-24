package com.quantity.QuantityMeasurementApp;

import java.util.Objects;

public class Length {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double toFeet() {
        return unit.toFeet(value);
    }

    //  UC5 instance conversion
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit null");

        double feet = this.toFeet();
        double converted = targetUnit.fromFeet(feet);

        return new Length(converted, targetUnit);
    }

    //  UC5 static API
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        double feet = source.toFeet(value);
        return target.fromFeet(feet);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;

        Length other = (Length) obj;
        return Math.abs(this.toFeet() - other.toFeet()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toFeet() / EPSILON));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}