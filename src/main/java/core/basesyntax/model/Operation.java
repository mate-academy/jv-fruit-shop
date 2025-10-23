package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String type;

    Operation(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Operation type is null or empty");
        }
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Operation getOperationType(String type) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unknown operation type: "
                                +
                                type + " . Expected one of: b, s, p, r"));
    }
}

