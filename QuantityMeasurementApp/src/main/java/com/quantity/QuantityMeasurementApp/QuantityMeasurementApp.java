package com.quantity.QuantityMeasurementApp;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Length Example
        Quantity feet = new Quantity(1, LengthUnit.FEET);
        Quantity inch = new Quantity(12, LengthUnit.INCH);

        System.out.println("1 Feet equals 12 Inch: " + feet.equals(inch));

        Quantity lengthSum = feet.add(inch);
        System.out.println("1 Feet + 12 Inch = " + lengthSum);

        // Weight Example
        Quantity kg = new Quantity(1, WeightUnit.KILOGRAM);
        Quantity gram = new Quantity(1000, WeightUnit.GRAM);

        System.out.println("1 Kg equals 1000 Gram: " + kg.equals(gram));

        Quantity weightSum = kg.add(new Quantity(500, WeightUnit.GRAM));
        System.out.println("1 Kg + 500 Gram = " + weightSum);

        // Volume Example
        Quantity litre = new Quantity(1, VolumeUnit.LITRE);
        Quantity ml = new Quantity(500, VolumeUnit.MILLILITRE);

        System.out.println("1 Litre + 500 ML = " + litre.add(ml));

        Quantity gallon = new Quantity(1, VolumeUnit.GALLON);
        System.out.println("1 Gallon equals 3.78 Litre: " +
                gallon.equals(new Quantity(3.78, VolumeUnit.LITRE)));
    }
}