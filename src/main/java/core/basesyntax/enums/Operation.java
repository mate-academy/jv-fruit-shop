package core.basesyntax.enums;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String value;
    Operation(String value) {
        this.value = value;
    }

    public static Operation getType(String value) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Invalid operation type: " + value));
    }
}
