package core.basesyntax;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    Operation(String code) {
        this.code = code;
    }
    private String code;

    public String getCode() {
        return code;
    }

    public static Operation getOperationFromCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("The entered code " + code + " does not match any operation.");
    }
}
