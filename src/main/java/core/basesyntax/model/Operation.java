package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation getOperation(String inputOperation) {
        return Arrays.stream(Operation.values())
                .filter(s -> s.operation.equals(inputOperation))
                .reduce((t1, t2) -> t1)
                .orElseThrow(() -> new RuntimeException("Can't find current enum"
                        + inputOperation));
    }
}
