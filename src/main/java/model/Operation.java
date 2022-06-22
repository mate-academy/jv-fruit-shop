package model;

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

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationByName(String name) {
        return Arrays.stream(Operation.values())
                    .filter(x -> x.getOperation().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Not allowed operation"));
    }
}
