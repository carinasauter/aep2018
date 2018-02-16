package edu.berkeley.aep;

// Understands how to convert between different units of the same type
public enum Unit {
    INCH(1, 0, UnitType.DISTANCE),
    FOOT(12, 0, UnitType.DISTANCE),
    YARD(12 * 3, 0, UnitType.DISTANCE),
    MILE(12 * 3 * 1760, 0, UnitType.DISTANCE),
    TBSP(3, 0, UnitType.VOLUME),
    TSP(1, 0, UnitType.VOLUME),
    OZ(6, 0, UnitType.VOLUME),
    CUP(48, 0, UnitType.VOLUME),
    FAHRENHEIT(5, -32, UnitType.TEMPERATURE),
    CELSIUS(9, 0, UnitType.TEMPERATURE);

    private final int inBase;
    private final int offset;
    private final UnitType type;

    private enum UnitType { DISTANCE, TEMPERATURE, VOLUME }

    Unit(int inBase, int offset, UnitType type) {
        this.inBase = inBase;
        this.offset = offset;
        this.type = type;
    }

    public int convertTo(Unit units, int size) {
        if (type != units.type) {
            throw new RuntimeException("You can't compare " + type + " to " + units.type + "!");
        }
        return ((size + offset) * inBase / units.inBase) - units.offset;
    }
}
