package core.basesyntax.service;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private String operationsType;

    Operation(String operationType) {
        this.operationsType = operationType;
    }

    public static Operation getOperationTypeByLetter(String letter) {
        for (Operation operation : Operation.values()) {
            if (operation.operationsType.equals(letter)) {
                return operation;
            }
        }
        throw new RuntimeException("Illegal operation: " + letter);
    }
}
