package core.basesyntax.transaction;

public class Validator {
    public static final String NULL_ARG_FORMAT = "Argument '%s' must not be null";
    public static final String NEGATIVE_ARG_FORMAT = "Argument '%s' must be >= 0, but was %d";

    public static void validate(String item, Integer quantity) {
        if (item == null) {
            throw new IllegalArgumentException(
                    String.format(NULL_ARG_FORMAT, "item")
            );
        }
        if (quantity == null) {
            throw new IllegalArgumentException(
                    String.format(NULL_ARG_FORMAT, "quantity")
            );
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    String.format(NEGATIVE_ARG_FORMAT, "quantity", quantity)
            );
        }
    }
}
