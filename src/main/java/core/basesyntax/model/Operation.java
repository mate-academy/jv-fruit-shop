package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation fromString(String operation) {
        for (Operation operationEnum : Operation.values()) {
            if (operationEnum.operation.equalsIgnoreCase(operation)) {
                return operationEnum;
            }
        }
        throw new IllegalArgumentException("No constant with operation " + operation + " found");
    }
}
