package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation parse(String operation) {
        return operation.equals(BALANCE.getOperation()) ? BALANCE
                : operation.equals(SUPPLY.getOperation()) ? SUPPLY
                : operation.equals(PURCHASE.getOperation()) ? PURCHASE
                : RETURN;
    }

    public String getOperation() {
        return operation;
    }
}
