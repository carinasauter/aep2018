package edu.berkeley.aep;

public enum Unit {
    INCH(1), FOOT(12), YARD(12 * 3), MILE(12 * 3 * 1760);

    private final int inBase;

    Unit(int inBase) {
        this.inBase = inBase;
    }

    public int toBaseAmount(int magnitude) {
        return magnitude * inBase;
    }
}
