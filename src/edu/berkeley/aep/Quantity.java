package edu.berkeley.aep;

// Understands how to compare measurements with a size and a unit
public class Quantity {
    private final int size;
    private final Unit units;

    public Quantity(int size, Unit units) {
        this.size = size;
        this.units = units;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Quantity)) return false;
        Quantity otherQuantity = (Quantity) other;
        try {
            return size == otherQuantity.convertTo(units).size;
        } catch (RuntimeException exception) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(size);
    }

    public Quantity convertTo(Unit other) {
        return new Quantity(units.convertTo(other, size), other);
    }

    public Quantity add(Quantity other) {
        return new Quantity(size + other.convertTo(units).size, units);
    }
}
