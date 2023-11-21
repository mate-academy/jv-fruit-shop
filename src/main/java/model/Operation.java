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

    public static Operation getOperation(String string) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(string)) {
                return operation;
            }
        }
        return null;
    }
}
