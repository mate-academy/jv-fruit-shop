package core.basesyntax.model;

public enum OperationWithFruit {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationName;

    OperationWithFruit(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public static OperationWithFruit findOperation(String operationType) {
        for (OperationWithFruit operation : values()) {
            if (operation.getOperationName().equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("Not valid operation type: " + operationType);
    }
}
