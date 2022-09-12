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

    public static Operation getOperationEnum(String operation) {
        for (Operation op : Operation.values()) {
            if (op.operation.equals(operation)) {
                return op;
            }
        }
        return null;
    }
}
