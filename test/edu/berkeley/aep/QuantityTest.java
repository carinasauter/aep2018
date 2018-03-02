package edu.berkeley.aep;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class QuantityTest {

    @Test
    public void oneFootShouldEqualTwelveInches() {
        assertEquals(new ScaledQuantity(1, Unit.FOOT), new ScaledQuantity(12, Unit.INCH));
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        assertEquals(new ScaledQuantity(3, Unit.FOOT), new ScaledQuantity(1, Unit.YARD));
    }

    @Test
    public void oneMileShouldEqual1760Yard() {
        assertEquals(new ScaledQuantity(1, Unit.MILE), new ScaledQuantity(1760, Unit.YARD));
    }

    @Test
    public void oneTablespoonShouldEqualThreeTeaspoons() {
        assertEquals(new ScaledQuantity(1, Unit.TBSP), new ScaledQuantity(3, Unit.TSP));
    }

    @Test
    public void twoTablespoonsShouldEqualOneOz() {
        assertEquals(new ScaledQuantity(2, Unit.TBSP), new ScaledQuantity(1, Unit.OZ));
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        assertEquals(new ScaledQuantity(8, Unit.OZ), new ScaledQuantity(1, Unit.CUP));
    }

    @Test(expected = RuntimeException.class)
    public void oneTeaspoonShouldNotBeComparableToOneFoot() {
        new ScaledQuantity(1, Unit.TSP).convertTo(Unit.FOOT);
    }

    @Test
    public void eightOzShouldEqualOneCupWithConvert() {
        assertEquals(new ScaledQuantity(8, Unit.OZ), new ScaledQuantity(1, Unit.CUP).convertTo(Unit.OZ));
    }

    @Test
    public void twoInchesPlusTwoInchesShouldBeFourInches() {
        assertEquals(new ScaledQuantity(4, Unit.INCH),
                new ArithmeticQuantity(2, Unit.INCH).add(new ArithmeticQuantity(2, Unit.INCH)));
    }

    @Test
    public void twoTablespoonsPlusOneOzShouldEqual12Tsp() {
        assertEquals(new ArithmeticQuantity(12, Unit.TSP),
                new ArithmeticQuantity(2, Unit.TBSP).add(new ArithmeticQuantity(1, Unit.OZ)));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToAddInchesAndTeaspoons() {
        new ArithmeticQuantity(1, Unit.INCH).add(new ArithmeticQuantity(1, Unit.TSP));
    }

    @Test
    public void twoHundredTwelveCelsiusShouldEqual100Fahrenheit() {
        assertEquals(new ScaledQuantity(212, Unit.FAHRENHEIT), new ScaledQuantity(100, Unit.CELSIUS));
    }

    @Test
    public void thirtyTwoFahrenheitShouldEqualZeroCelsius() {
        assertEquals(new ScaledQuantity(0, Unit.CELSIUS), new ScaledQuantity(32, Unit.FAHRENHEIT));
    }

    @Test
    public void tenCelsiusShouldBeBetterThanThirtyTwoFahrenheit() {
        assertTrue(new ScaledQuantity(10, Unit.CELSIUS).betterThan(new ScaledQuantity(32, Unit.FAHRENHEIT)));
    }

    @Test
    public void shouldReturnHighestQuantity() {
        ArithmeticQuantity oneInch = new ArithmeticQuantity(1, Unit.INCH);
        ArithmeticQuantity oneFoot = new ArithmeticQuantity(1, Unit.FOOT);
        ArithmeticQuantity oneYard = new ArithmeticQuantity(1, Unit.YARD);
        List<ArithmeticQuantity> toSort = new ArrayList<>();
        toSort.add(oneInch);
        toSort.add(oneFoot);
        toSort.add(oneYard);
        Bester bester = new Bester(toSort);
        assertEquals(oneYard, bester.best());
    }
}