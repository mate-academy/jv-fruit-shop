package core.basesyntax.model;

public enum Operation {
    BALANCE("bl"),
    SUPPLY("s"),
    BUY("b"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
