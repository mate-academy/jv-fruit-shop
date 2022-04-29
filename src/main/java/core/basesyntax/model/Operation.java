package core.basesyntax.model;

public enum Operation {
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r"),
    BALANCE("b");

    private String operationFirstChar;

    Operation(String operationFirstChar) {
        this.operationFirstChar = operationFirstChar;
    }

    public String getOperationFirstChar() {
        return operationFirstChar;
    }

    public static Operation getOperation(String incomingOperation) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperationFirstChar().equals(incomingOperation)) {
                return operation;
            }
        }
        return null;
    }
}
