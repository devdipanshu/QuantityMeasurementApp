package com.quantity.QuantityMeasurementApp;

import java.util.Objects;

public class QuantityWeight {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double toKilogram() {
        return unit.convertToBaseUnit(value);
    }

    public QuantityWeight convertTo(WeightUnit target) {
        if (target == null)
            throw new IllegalArgumentException("Target unit null");

        double kg = this.toKilogram();
        double converted = target.convertFromBaseUnit(kg);

        return new QuantityWeight(converted, target);
    }

    public QuantityWeight add(QuantityWeight other) {
        if (other == null)
            throw new IllegalArgumentException("Other weight null");

        double sumKg = this.toKilogram() + other.toKilogram();
        double result = this.unit.convertFromBaseUnit(sumKg);

        return new QuantityWeight(result, this.unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit target) {
        if (other == null || target == null)
            throw new IllegalArgumentException("Invalid input");

        double sumKg = this.toKilogram() + other.toKilogram();
        double result = target.convertFromBaseUnit(sumKg);

        return new QuantityWeight(result, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Math.abs(this.toKilogram() - other.toKilogram()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toKilogram() / EPSILON));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}