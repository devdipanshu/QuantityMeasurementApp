package com.quantity.QuantityMeasurementApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeightTest {
    @Test
    void oneKgShouldEqualThousandGram() {
        QuantityWeight kg = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight gram = new QuantityWeight(1000, WeightUnit.GRAM);

        Assertions.assertEquals(kg, gram);
    }

    @Test
    void oneKgShouldEqualTwoPointTwoPound() {
        QuantityWeight kg = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight pound = new QuantityWeight(2.20462, WeightUnit.POUND);

        Assertions.assertEquals(kg, pound);
    }

    @Test
    void additionKgAndGram() {
        QuantityWeight kg = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000, WeightUnit.GRAM);

        Assertions.assertEquals(new QuantityWeight(2, WeightUnit.KILOGRAM), kg.add(g));
    }
}
