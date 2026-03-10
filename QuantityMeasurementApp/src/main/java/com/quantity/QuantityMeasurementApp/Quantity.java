package com.quantity.QuantityMeasurementApp;

import java.util.Objects;

public class Quantity {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final Unit unit;

    public Quantity(double value, Unit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Quantity convertTo(Unit target) {

        double base = this.toBaseUnit();
        double converted = target.convertFromBaseUnit(base);

        return new Quantity(converted, target);
    }

    public Quantity add(Quantity other) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = unit.convertFromBaseUnit(sum);

        return new Quantity(result, unit);
    }

    public Quantity add(Quantity other, Unit target) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = target.convertFromBaseUnit(sum);

        return new Quantity(result, target);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() / EPSILON));
    }
}