package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Validates that a rectangle has four sides and four right angles
public class RectangleTest {

    @Test
    public void rectangleWithSidesTwoByTwoShouldHaveAreaFour() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(4, rectangle.area());
    }

    @Test
    public void rectangleWithSidesTwoByFourShouldHaveAreaEight() {
        Rectangle rectangle = new Rectangle(2, 4);
        assertEquals(8, rectangle.area());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rectangleWithNegativeWidthShouldNotBeCreatable() {
        Rectangle rectangle = new Rectangle(-2, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rectangleWithNegativeLengthShouldNotBeCreatable() {
        Rectangle rectangle = new Rectangle(2, -4);
    }

    @Test
    public void squareWithSideTwoShouldHaveAreaFour() {
        Rectangle square = Rectangle.createSquare(2);
        assertEquals(4, square.area());
    }
}
