package com.quantity.QuantityMeasurementApp;

public class LengthApp {
    public static void main(String[] args) {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCH);

        System.out.println(l1.equals(l2));
    }
}
