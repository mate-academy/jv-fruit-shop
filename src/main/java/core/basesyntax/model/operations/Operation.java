package core.basesyntax.model.operations;

import java.util.Arrays;

public enum Operation {
    B("b"), S("s"), P("p"), R("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationByLetter(String letter) {
        return Arrays.stream(Operation.values())
                .filter(value -> value.getOperation().equals(letter))
                .findFirst()
                .get();
    }
}
