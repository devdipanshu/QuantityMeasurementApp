package com.quantity.QuantityMeasurementApp;

public class LengthApp {
    public static void main(String[] args) {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCH);

        System.out.println("Equality: " + l1.equals(l2));

        // UC5 conversion
        System.out.println("Convert: " + l1.convertTo(LengthUnit.INCH));

        // UC6 addition
        System.out.println("Add: " + l1.add(l2));
    }
}