package core.basesyntax.service.impl;

public enum Operation {
    BALANCE("b"), SUPPLY("s"), RETURN("r"), PURCHASE("p");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationByLetter(String letter) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperation().equals(letter)) {
                return operation;
            }
        }
        throw new RuntimeException("Invalid operation type - " + letter);
    }
}
