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

    // CENTRALIZED ARITHMETIC METHOD (UC13)
    private Quantity<U> operate(Quantity<U> other, U target, char operation) {

        double base1 = this.toBaseUnit();
        double base2 = other.toBaseUnit();

        double resultBase;

        switch (operation) {
            case '+':
                resultBase = base1 + base2;
                break;
            case '-':
                resultBase = base1 - base2;
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation");
        }

        double result = target.convertFromBaseUnit(resultBase);
        return new Quantity<>(result, target);
    }

    // ADD
    public Quantity<U> add(Quantity<U> other) {
        return operate(other, this.unit, '+');
    }

    public Quantity<U> add(Quantity<U> other, U target) {
        return operate(other, target, '+');
    }

    // SUBTRACT
    public Quantity<U> subtract(Quantity<U> other) {
        return operate(other, this.unit, '-');
    }

    public Quantity<U> subtract(Quantity<U> other, U target) {
        return operate(other, target, '-');
    }

    // DIVIDE
    public double divide(Quantity<U> other) {
        return this.toBaseUnit() / other.toBaseUnit();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() / EPSILON));
    }
}