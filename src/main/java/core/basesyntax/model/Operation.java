package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationName;

    Operation(String operationName) {
        this.operationName = operationName;
    }

    public static Operation findOperation(String operationType) {
        for (Operation operation : values()) {
            if (operation.operationName.equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("Not valid operation type: " + operationType);
    }
}
