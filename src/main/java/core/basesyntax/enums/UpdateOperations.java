package core.basesyntax.enums;

public enum UpdateOperations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    UpdateOperations(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
