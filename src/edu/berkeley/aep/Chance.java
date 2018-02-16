package edu.berkeley.aep;

// Understands the probability of something happening
public class Chance {
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Chance)) return false;
        return Double.compare(probability, ((Chance) other).probability) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    public Chance not() {
        return new Chance(1 - probability);
    }

    public Chance and(Chance other) {
        return new Chance(probability * other.probability);
    }

    public Chance or(Chance other) {
        // Uses De Morgan's Law
        return (not().and(other.not())).not();
    }
}
