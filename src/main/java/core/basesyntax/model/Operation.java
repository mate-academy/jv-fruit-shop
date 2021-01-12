package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation getOperationFromString(String latter) {
        for (Operation operation: Operation.values()) {
            if (operation.operation.equals(latter)) {
                return operation;
            }
        }
        throw new RuntimeException("Unknown operation: " + latter);
    }
}


