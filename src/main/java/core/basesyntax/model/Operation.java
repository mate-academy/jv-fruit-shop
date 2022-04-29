package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String type;

    Operation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Operation get(String type) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getType().contains(type))
                .findFirst().get();
    }
}
