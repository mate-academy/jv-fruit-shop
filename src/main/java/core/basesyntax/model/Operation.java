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

    public static Operation getByCode(String operation) {
        for (Operation op : Operation.values()) {
            if (op.operation.equals(operation)) {
                return op;
            }
        }
        throw new RuntimeException("Can't find Operation by letter " + operation);
    }

}
