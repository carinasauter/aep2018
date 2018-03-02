package edu.berkeley.aep;

public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(int size, Unit units) {
        super(size, units);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        return new ArithmeticQuantity(this.size + other.convertTo(this.units).size, this.units);
    }

}
