package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");


    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation operationFromCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid code of the operation: " + code);
    }

    public String getCode() {
        return code;
    }
}
