package converter;

/**
 * A Length enum for Length units. Meter is the standard unit.
 *
 * @author Pornpavee Seri-umnuoy
 */
public enum Length {

    Mile(1609.344),
    Kilometer(1000.0),
    Meter(1.0),
    Centimeter(0.0100),
    Foot(0.30480),
    Wa(2.00000),
    AU(149597870700l);
    // attributes of the enum members
    private final double value;

    // constructor must be private
    private Length(double value) {
        this.value = value;
    }

    // methods just like in a class
    public double getValue() {
        return this.value;
    }

    /**
     * for testing a Length enum.
     */
    public static void main(String[] args) {
        Length[] lengths = Length.values();

        for (Length x : lengths)
            System.out.println(x.toString() + " = " + x.getValue());

    }
}
