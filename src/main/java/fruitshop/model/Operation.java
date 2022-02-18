package fruitshop.model;

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

    public static Operation parse(String operation) {
        return Arrays.stream(values())
                .filter(o -> o.getOperation().equals(operation))
                .findFirst().orElseThrow(() ->
                        new RuntimeException("There is no such operation: " + operation));
    }

    public String getOperation() {
        return operation;
    }
}
