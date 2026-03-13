package com.quantity.QuantityMeasurementApp.app;

import com.quantity.QuantityMeasurementApp.controller.QuantityMeasurementController;
import com.quantity.QuantityMeasurementApp.dto.QuantityDTO;
import com.quantity.QuantityMeasurementApp.enums.LengthUnit;
import com.quantity.QuantityMeasurementApp.enums.TemperatureUnit;
import com.quantity.QuantityMeasurementApp.enums.VolumeUnit;
import com.quantity.QuantityMeasurementApp.enums.WeightUnit;
import com.quantity.QuantityMeasurementApp.repository.QuantityMeasurementDBRepository;
import com.quantity.QuantityMeasurementApp.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementController controller =
                new QuantityMeasurementController(
                        new QuantityMeasurementServiceImpl(
                                new QuantityMeasurementDBRepository()
                        )
                );

        // Length Example
        QuantityDTO feet = new QuantityDTO(1, LengthUnit.FEET);
        QuantityDTO inch = new QuantityDTO(12, LengthUnit.INCH);

        System.out.println("1 Feet equals 12 Inch: " +
                controller.compare(feet, inch));

        System.out.println("1 Feet + 12 Inch = " +
                controller.add(feet, inch).getValue());

        // Weight Example
        QuantityDTO kg = new QuantityDTO(1, WeightUnit.KILOGRAM);
        QuantityDTO gram = new QuantityDTO(1000, WeightUnit.GRAM);

        System.out.println("1 Kg equals 1000 Gram: " +
                controller.compare(kg, gram));

        System.out.println("1 Kg + 500 Gram = " +
                controller.add(kg, new QuantityDTO(500, WeightUnit.GRAM)).getValue());

        // Volume Example
        QuantityDTO litre = new QuantityDTO(1, VolumeUnit.LITRE);
        QuantityDTO ml = new QuantityDTO(500, VolumeUnit.MILLILITRE);

        System.out.println("1 Litre + 500 ML = " +
                controller.add(litre, ml).getValue());

        QuantityDTO gallon = new QuantityDTO(1, VolumeUnit.GALLON);

        System.out.println("1 Gallon equals 3.78 Litre: " +
                controller.compare(gallon, new QuantityDTO(3.78, VolumeUnit.LITRE)));

        // Temperature Example
        QuantityDTO c0 = new QuantityDTO(0.0, TemperatureUnit.CELSIUS);
        QuantityDTO f32 = new QuantityDTO(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("0°C equals 32°F: " +
                controller.compare(c0, f32));

        QuantityDTO c100 = new QuantityDTO(100.0, TemperatureUnit.CELSIUS);

        System.out.println("100°C → Fahrenheit: " +
                controller.convert(c100, TemperatureUnit.FAHRENHEIT).getValue());
        try {
            controller.add(c100, new QuantityDTO(50.0, TemperatureUnit.CELSIUS));
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}