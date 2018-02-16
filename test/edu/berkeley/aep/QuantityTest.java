package edu.berkeley.aep;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class QuantityTest {

    @Test
    public void oneFootShouldEqualTwelveInches() {
        assertEquals(new Quantity(1, Unit.FOOT), new Quantity(12, Unit.INCH));
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        assertEquals(new Quantity(3, Unit.FOOT), new Quantity(1, Unit.YARD));
    }

    @Test
    public void oneMileShouldEqual1760Yard() {
        assertEquals(new Quantity(1, Unit.MILE), new Quantity(1760, Unit.YARD));
    }

    @Test
    public void oneTablespoonShouldEqualThreeTeaspoons() {
        assertEquals(new Quantity(1, Unit.TBSP), new Quantity(3, Unit.TSP));
    }

    @Test
    public void twoTablespoonsShouldEqualOneOz() {
        assertEquals(new Quantity(2, Unit.TBSP), new Quantity(1, Unit.OZ));
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        assertEquals(new Quantity(8, Unit.OZ), new Quantity(1, Unit.CUP));
    }

    @Test(expected = RuntimeException.class)
    public void oneTeaspoonShouldNotBeComparableToOneFoot() {
        new Quantity(1, Unit.TSP).convertTo(Unit.FOOT);
    }

    @Test
    public void eightOzShouldEqualOneCupWithConvert() {
        assertEquals(new Quantity(8, Unit.OZ), new Quantity(1, Unit.CUP).convertTo(Unit.OZ));
    }

    @Test
    public void twoInchesPlusTwoInchesShouldBeFourInches() {
        assertEquals(new Quantity(4, Unit.INCH),
                new Quantity(2, Unit.INCH).add(new Quantity(2, Unit.INCH)));
    }

    @Test
    public void twoTablespoonsPlusOneOzShouldEqual12Tsp() {
        assertEquals(new Quantity(12, Unit.TSP),
                new Quantity(2, Unit.TBSP).add(new Quantity(1, Unit.OZ)));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToAddInchesAndTeaspoons() {
        new Quantity(1, Unit.INCH).add(new Quantity(1, Unit.TSP));
    }
}
