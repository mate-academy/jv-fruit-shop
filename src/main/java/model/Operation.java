package model;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation fromString(String stringType) {
        for (Operation type : Operation.values()) {
            if (type.operation.equals(stringType)) {
                return type;
            }
        }
        return null;
    }
}
