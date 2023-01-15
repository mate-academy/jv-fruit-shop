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

    public static Operation getOperation(String sign) {
        for (Operation newOperation: Operation.values()) {
            if (sign.trim().equals(newOperation.operation)) {
                return newOperation;
            }
        }
        throw new RuntimeException("Can't find operation "
                + sign);
    }
}
