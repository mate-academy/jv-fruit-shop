package core.basesyntax.operations;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperationFromString(String operationType) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(operationType)) {
                return operation;
            }
        }
        throw new IllegalArgumentException(operationType + " operation doesn't exist");
    }
}
