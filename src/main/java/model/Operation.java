package model;

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

    public static Operation getOperation(String operationSymbol) {
        for (Operation value : Operation.values()) {
            if (value.getCode().equals(operationSymbol)) {
                return value;
            }
        }
        throw new RuntimeException("No such operation");
    }
}
