package edu.berkeley.aep;

public class Quantity {
    private final int magnitude;
    private final Unit units;

    public Quantity(int magnitude, Unit units) {
        this.magnitude = magnitude;
        this.units = units;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Quantity)) return false;
        Quantity otherQuantity = (Quantity) other;
        return units.toBaseAmount(magnitude) == otherQuantity.units.toBaseAmount(otherQuantity.magnitude);
    }
}
