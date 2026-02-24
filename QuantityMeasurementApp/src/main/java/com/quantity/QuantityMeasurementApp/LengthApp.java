package com.quantity.QuantityMeasurementApp;

public class LengthApp {

    public static void main(String[] args) {

        System.out.println(Length.convert(1, LengthUnit.FEET, LengthUnit.INCH));

        Length yard = new Length(1, LengthUnit.YARDS);
        System.out.println(yard.convertTo(LengthUnit.FEET));
    }
}