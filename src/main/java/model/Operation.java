package model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private static final String CAN_NOT_FIND_OPERATION = "Can not find suitable Operation ";
    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation findRightOperation(String operation) {
        for (Operation op : Operation.values()) {
            if (op.operation.equals(operation)) {
                return op;
            }
        }
        throw new RuntimeException(CAN_NOT_FIND_OPERATION + operation);
    }
}

