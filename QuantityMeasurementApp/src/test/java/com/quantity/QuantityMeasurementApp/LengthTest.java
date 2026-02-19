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
}

