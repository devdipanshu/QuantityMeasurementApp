package com.quantity.QuantityMeasurementApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LengthTest {

    @Test
    void sameFeetShouldBeEqual() {
        Length l1 = new Length(2, LengthUnit.FEET);
        Length l2 = new Length(2, LengthUnit.FEET);

        Assertions.assertEquals(l1, l2);
    }

    @Test
    void differentFeetShouldNotBeEqual() {
        Length l1 = new Length(2, LengthUnit.FEET);
        Length l2 = new Length(3, LengthUnit.FEET);

        Assertions.assertNotEquals(l1, l2);
    }

    @Test
    void oneFeetShouldEqualTwelveInch() {
        Length feet = new Length(1, LengthUnit.FEET);
        Length inch = new Length(12, LengthUnit.INCH);

        Assertions.assertEquals(feet, inch);
    }

    @Test
    void oneFeetShouldNotEqualElevenInch() {
        Length feet = new Length(1, LengthUnit.FEET);
        Length inch = new Length(11, LengthUnit.INCH);

        Assertions.assertNotEquals(feet, inch);
    }

    @Test
    void zeroLengthShouldBeEqual() {
        Length l1 = new Length(0, LengthUnit.FEET);
        Length l2 = new Length(0, LengthUnit.INCH);

        Assertions.assertEquals(l1, l2);
    }

    //UC4 TestCases:

    @Test
    void yardToFeetEquality() {
        Length yard = new Length(1, LengthUnit.YARDS);
        Length feet = new Length(3, LengthUnit.FEET);

        Assertions.assertEquals(yard, feet);
    }

    @Test
    void yardToInchEquality() {
        Length yard = new Length(1, LengthUnit.YARDS);
        Length inch = new Length(36, LengthUnit.INCH);

        Assertions.assertEquals(yard, inch);
    }

    @Test
    void cmToInchEquality() {
        Length cm = new Length(1, LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, LengthUnit.INCH);

        Assertions.assertEquals(cm, inch);
    }

    //UC5 TestCases

    @Test
    void convertFeetToInch() {
        double result = Length.convert(1, LengthUnit.FEET, LengthUnit.INCH);
        Assertions.assertEquals(12, result, 0.0001);
    }

    @Test
    void convertYardToFeet() {
        double result = Length.convert(1, LengthUnit.YARDS, LengthUnit.FEET);
        Assertions.assertEquals(3, result, 0.0001);
    }

    @Test
    void instanceConversion() {
        Length yard = new Length(1, LengthUnit.YARDS);
        Length feet = yard.convertTo(LengthUnit.FEET);

        Assertions.assertEquals(new Length(3, LengthUnit.FEET), feet);
    }

}



