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


    @Test
    void additionFeetPlusFeet() {
        Length l1 = new Length(1, LengthUnit.FEET);
        Length l2 = new Length(2, LengthUnit.FEET);

        Assertions.assertEquals(new Length(3, LengthUnit.FEET), l1.add(l2));
    }

    @Test
    void additionFeetPlusInch() {
        Length feet = new Length(1, LengthUnit.FEET);
        Length inch = new Length(12, LengthUnit.INCH);

        Assertions.assertEquals(new Length(2, LengthUnit.FEET), feet.add(inch));
    }

    @Test
    void additionInchPlusFeet() {
        Length inch = new Length(12, LengthUnit.INCH);
        Length feet = new Length(1, LengthUnit.FEET);

        Assertions.assertEquals(new Length(24, LengthUnit.INCH), inch.add(feet));
    }

    @Test
    void additionYardPlusFeet() {
        Length yard = new Length(1, LengthUnit.YARDS);
        Length feet = new Length(3, LengthUnit.FEET);

        Assertions.assertEquals(new Length(2, LengthUnit.YARDS), yard.add(feet));
    }

    @Test
    void additionWithZero() {
        Length l1 = new Length(5, LengthUnit.FEET);
        Length zero = new Length(0, LengthUnit.INCH);

        Assertions.assertEquals(l1, l1.add(zero));
    }

    @Test
    void additionNegativeValues() {
        Length l1 = new Length(5, LengthUnit.FEET);
        Length l2 = new Length(-2, LengthUnit.FEET);

        Assertions.assertEquals(new Length(3, LengthUnit.FEET), l1.add(l2));
    }

    @Test
    void additionCommutativeCheck() {
        Length a = new Length(1, LengthUnit.FEET);
        Length b = new Length(12, LengthUnit.INCH);

        Assertions.assertEquals(a.add(b).toFeet(), b.add(a).toFeet(), 0.0001);
    }

    @Test
    void additionCentimeterPlusInch() {
        Length cm = new Length(2.54, LengthUnit.CENTIMETERS);
        Length inch = new Length(1, LengthUnit.INCH);

        Length result = cm.add(inch);

        Assertions.assertEquals(5.08, result.convertTo(LengthUnit.CENTIMETERS).toFeet() /
                LengthUnit.CENTIMETERS.toFeet(1), 0.01);
    }

}