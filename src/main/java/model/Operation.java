package model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation parse(String operationSymbol) {
        for (Operation operation : values()) {
            if (operation.getCode().equals(operationSymbol)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown operation symbol: " + operationSymbol);
    }
}
