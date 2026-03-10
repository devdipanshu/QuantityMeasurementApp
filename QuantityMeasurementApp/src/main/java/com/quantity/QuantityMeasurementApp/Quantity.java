package com.quantity.QuantityMeasurementApp;

import java.util.Objects;

public class Quantity<U extends Unit> {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

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

    public Quantity<U> convertTo(U target) {

        double base = this.toBaseUnit();
        double converted = target.convertFromBaseUnit(base);

        return new Quantity<>(converted, target);
    }

    // ADDITION
    public Quantity<U> add(Quantity<U> other) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = unit.convertFromBaseUnit(sum);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U target) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = target.convertFromBaseUnit(sum);

        return new Quantity<>(result, target);
    }

    // SUBTRACTION (UC12)
    public Quantity<U> subtract(Quantity<U> other) {

        double diff = this.toBaseUnit() - other.toBaseUnit();
        double result = unit.convertFromBaseUnit(diff);

        return new Quantity<>(result, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U target) {

        double diff = this.toBaseUnit() - other.toBaseUnit();
        double result = target.convertFromBaseUnit(diff);

        return new Quantity<>(result, target);
    }

    // DIVISION (UC12)
    public double divide(Quantity<U> other) {

        double base1 = this.toBaseUnit();
        double base2 = other.toBaseUnit();

        if (Math.abs(base2) < EPSILON)
            throw new ArithmeticException("Division by zero");

        return base1 / base2;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() / EPSILON));
    }
}