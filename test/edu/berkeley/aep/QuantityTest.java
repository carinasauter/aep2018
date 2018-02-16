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
}
