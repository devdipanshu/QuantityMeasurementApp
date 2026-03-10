package com.quantity.QuantityMeasurementApp;

public class LengthApp {

    public static void main(String[] args) {

        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(12, LengthUnit.INCH);

        // UC5 Conversion
        Length converted = l1.convertTo(LengthUnit.INCH);
        System.out.println("1 Foot in Inch = " + converted);

        // UC6 Addition
        Length result1 = l1.add(l2);
        System.out.println("1 Foot + 12 Inch = " + result1);

        // UC7 Addition with target unit
        Length result2 = l1.add(l2, LengthUnit.INCH);
        System.out.println("Result in Inch = " + result2);

        Length result3 = l1.add(l2, LengthUnit.YARDS);
        System.out.println("Result in Yards = " + result3);
    }
}