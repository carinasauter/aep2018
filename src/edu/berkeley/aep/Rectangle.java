package edu.berkeley.aep;

public class Rectangle {
    private final int width;
    private final int length;

    public Rectangle(int width, int length) {
        if (width < 0 || length < 0) {
            throw new IllegalArgumentException("Sides must be positive integers");
        }
        this.width = width;
        this.length = length;
    }

    public int area() {
        return width * length;
    }

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }
}
