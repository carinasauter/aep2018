package edu.berkeley.aep;

import java.util.List;

public class Bester {
    private final List<ArithmeticQuantity> toSort;

    public Bester(List<ArithmeticQuantity> toSort) {
        this.toSort = toSort;
    }

    public ArithmeticQuantity best() {
        ArithmeticQuantity champion = toSort.get(0);
        for (ArithmeticQuantity challenger : toSort) {
            if (challenger.betterThan(champion)) {
                champion = challenger;
            }
        }
        return champion;
    }


}
