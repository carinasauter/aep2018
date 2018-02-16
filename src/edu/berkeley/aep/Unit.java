package edu.berkeley.aep;

// Understands how to convert between different units of the same type
public enum Unit {
    INCH(1, UnitType.DISTANCE),
    FOOT(12, UnitType.DISTANCE),
    YARD(12 * 3, UnitType.DISTANCE),
    MILE(12 * 3 * 1760, UnitType.DISTANCE),
    TBSP(3, UnitType.VOLUME),
    TSP(1, UnitType.VOLUME),
    OZ(6, UnitType.VOLUME),
    CUP(48, UnitType.VOLUME);

    private final int inBase;
    private final UnitType type;

    private enum UnitType { DISTANCE, VOLUME }

    Unit(int inBase, UnitType type) {
        this.inBase = inBase;
        this.type = type;
    }

    public int convertTo(Unit units, int size) {
        if (type != units.type) {
            throw new RuntimeException("You can't compare " + type + " to " + units.type + "!");
        }
        return size * inBase / units.inBase;
    }
}
