package edu.berkeley.aep;

public class ScaledQuantity {
    protected final int size;
    protected final Unit units;

    public ScaledQuantity(int size, Unit units) {
        this.size = size;
        this.units = units;
    }

    @Override
    public boolean equals (Object other) {
        if (this == other) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQuantity = (ScaledQuantity) other;
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

    public ScaledQuantity convertTo(Unit other) {
        return new ScaledQuantity(units.convertTo(other, size), other);
    }

    public boolean betterThan (ScaledQuantity other) {
        return size > other.convertTo(this.units).size;
    }
}
