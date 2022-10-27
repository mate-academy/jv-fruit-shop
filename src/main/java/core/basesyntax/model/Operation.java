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

    public String getOperation() {
        return operation;
    }

    public static Operation provideOperation(String operationType) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperation().equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("Can't find such operator " + operationType);
    }
}
