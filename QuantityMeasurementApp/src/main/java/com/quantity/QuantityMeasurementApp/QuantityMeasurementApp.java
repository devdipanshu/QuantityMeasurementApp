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

        Quantity<TemperatureUnit> c0 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> f32 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("0°C equals 32°F: " + c0.equals(f32));

        Quantity<TemperatureUnit> c100 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> f212 = c100.convertTo(TemperatureUnit.FAHRENHEIT);

        System.out.println("100°C → Fahrenheit: " + f212.getValue());

        try {
            c100.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS));
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}