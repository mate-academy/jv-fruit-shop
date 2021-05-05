package core.basesyntax.service.operations;

public enum OperationType {
    BALANCE("b"), SUPPLY("s"), RETURN("r"), PURCHASE("p");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
