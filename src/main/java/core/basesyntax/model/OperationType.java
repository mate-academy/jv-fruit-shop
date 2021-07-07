package core.basesyntax.model;

import java.util.Arrays;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String value;

    OperationType(String value) {
        this.value = value;
    }

    public static OperationType getOperationType(String symbol) {
        return Arrays.stream(OperationType.values())
                .filter(e -> e.value.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal operation type: " + symbol));
    }
}
