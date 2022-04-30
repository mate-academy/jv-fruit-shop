package core.basesyntax.operation;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperation(String string) {
        return Arrays.stream(values())
                .filter(o -> o.getOperation().equals(string))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Operation character not recognized"));
    }
}
