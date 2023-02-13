package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operationChar;

    Operation(String operation) {
        this.operationChar = operation;
    }

    public String getOperationChar() {
        return operationChar;
    }
}
