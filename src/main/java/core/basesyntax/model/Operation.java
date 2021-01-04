package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationSignature;

    Operation(String operationSignature) {
        this.operationSignature = operationSignature;
    }

    public String getOperation() {
        return operationSignature;
    }

    public static Operation fromString(String operationSignature) {
        for (Operation operation : Operation.values()) {
            if (operation.operationSignature.equalsIgnoreCase(operationSignature)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation is incorrect " + operationSignature);
    }
}
